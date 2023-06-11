package com.example.usuarios;

import android.Manifest;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

public class MainActivity extends AppCompatActivity {

    SimpleCursorAdapter adapter;
    private LoaderManager.LoaderCallbacks<Cursor> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acessar_contatos();
    }

    private boolean acessar_contatos() {
        if (ContextCompat.checkSelfPermission(
                getApplicationContext(),
                Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_CONTACTS,
                            Manifest.permission.READ_CONTACTS},
                    9876);
            return false;
        }
        contatos = new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                String[] campos = new String[]{ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.DISPLAY_NAME};

                CursorLoader cursorLoader = new CursorLoader(
                        MainActivity.this,
                        ContactsContract.Contacts.CONTENT_URI,
                        campos, null, null, null);
                return cursorLoader;
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                cursor.moveToFirst();
                if (!cursor.isAfterLast()) {
                    StringBuilder bld = new StringBuilder(1000);
                    do {
                        bld.append(cursor.getString(0));
                        bld.append(" - ");
                        bld.append(cursor.getString(1));
                        bld.append('\n');
                    } while (cursor.moveToNext());
                    TextView tv = (TextView) findViewById(R.id.listaContatos);
                    tv.setText(bld.toString());
                }
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
            }
        };
        LoaderManager.getInstance(this).initLoader(1, new Bundle(), contatos);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissoes,
                                           @NonNull int[] resultados) {
        super.onRequestPermissionsResult(requestCode, permissoes, resultados);
        if (requestCode == 9876) {
            if (resultados.length > 0 && resultados[0] == PackageManager.PERMISSION_GRANTED) {
                acessar_contatos();
            } else {
                Toast.makeText(this, "è necessário o acesso aos contatos!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    public void inserir(View v) {
        if (ContextCompat.checkSelfPermission(
                getApplicationContext(),
                Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_CONTACTS,
                            Manifest.permission.READ_CONTACTS,}, 9876);
            return;
        }
        String nome = ((EditText) findViewById(R.id.ed_nome)).getText().toString();
        String email = ((EditText) findViewById(R.id.ed_mail)).getText().toString();
        String fone = ((EditText) findViewById(R.id.ed_fone)).getText().toString();
        if (nome.trim().length() == 0 || email.trim().length() == 0 || fone.trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Informe todos os dados do contato", Toast.LENGTH_LONG).show();
            return;
        }
        if (acessar_contatos()) {
            /********** TRAS PARA A TELA A ACTIVETY DO APLICATIVO NATIVO DOS CONTATOS PARA PODER ADICIONAR.
             Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
             intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
             intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
             intent.putExtra(ContactsContract.Intents.Insert.NAME, nome);
             intent.putExtra(ContactsContract.Intents.Insert.PHONE, fone);
             startActivity(intent);
             ********/

            ContentValues p = new ContentValues();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                p.put(ContactsContract.RawContacts.ACCOUNT_TYPE, ContactsContract.RawContacts.getLocalAccountType(this));
                p.put(ContactsContract.RawContacts.ACCOUNT_NAME, ContactsContract.RawContacts.getLocalAccountName(this));
            } else {
                p.put(ContactsContract.RawContacts.ACCOUNT_TYPE, "teste");
                p.put(ContactsContract.RawContacts.ACCOUNT_NAME, "teste");
            }
            Uri rowcontect = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, p);
            long rawcontectid = ContentUris.parseId(rowcontect);

            ContentValues value = new ContentValues();
            value.put(ContactsContract.Data.RAW_CONTACT_ID, rawcontectid);
            value.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
            value.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, nome);
            getContentResolver().insert(ContactsContract.Data.CONTENT_URI, value);

            //adding the contents to the data
            ContentValues ppv = new ContentValues();
            ppv.put(ContactsContract.Data.RAW_CONTACT_ID, rawcontectid);
            ppv.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            ppv.put(ContactsContract.CommonDataKinds.Phone.NUMBER, fone);
            ppv.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
            this.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, ppv);

            ContentValues mailval = new ContentValues();
            mailval.put(ContactsContract.Data.RAW_CONTACT_ID, rawcontectid);
            mailval.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
            mailval.put(ContactsContract.CommonDataKinds.Email.ADDRESS, email);
            mailval.put(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
            this.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, mailval);
        }
    }
}