import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import exceptions.ConnectionRefusedException;
import exceptions.DuplicityException;
import exceptions.EndOperationException;
import exceptions.EndProgramException;
import exceptions.InvalidOptionException;
import exceptions.RegisterNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                menu();
            } catch (EndProgramException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Fim", JOptionPane.INFORMATION_MESSAGE);
                break;
            } catch (EndOperationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Fim", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void menu()
            throws EndProgramException, EndOperationException, IOException, InvalidOptionException, DuplicityException {
        StringBuilder sb = new StringBuilder();
        sb.append("1 - Inserção\n");
        sb.append("2 - Consulta\n");
        sb.append("3 - Alteração\n");
        sb.append("4 - Remoção\n");

        String opcao = JOptionPane.showInputDialog(null, sb.toString(), "CSV CRUD", JOptionPane.QUESTION_MESSAGE);
        if (opcao == null) {
            throw new EndProgramException();
        }
        switch (opcao) {
            case "1":
                insercao();
                break;
            case "2":
                consulta();
                break;
            case "3":
                alteracao();
                break;
            case "4":
                remocao();
                break;
            default:
                throw new InvalidOptionException();
        }
    }

    private static void insercao() throws IOException, EndOperationException, DuplicityException {
        final String OPERATION_NAME = "Inserção";
        Region newRegion = new Region();

        while (true) {
            try {
                int id = Integer.parseInt(requestData(OPERATION_NAME, "Informe o ID da região:"));
                newRegion.setId(id);
                break;
            } catch (EndOperationException e) {
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), OPERATION_NAME, JOptionPane.WARNING_MESSAGE);
            }
        }

        while (true) {
            try {
                String name = requestData(OPERATION_NAME, "Informe o nome da região:");
                newRegion.setName(name);
                break;
            } catch (EndOperationException e) {
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), OPERATION_NAME, JOptionPane.WARNING_MESSAGE);
            }
        }

        List<Region> registers = FileManager.readFile();
        for (Region region : registers) {
            if (newRegion.getId() == region.getId()) {
                throw new DuplicityException();
            }
        }
        registers.add(newRegion);
        FileManager.writeFile(registers);
    }

    private static void consulta() throws IOException {
        final String OPERATION_NAME = "Consulta";
        List<Region> registers = FileManager.readFile();
        StringBuilder sb = new StringBuilder();

        sb.append("Regiões Encontradas:\n\n");
        for (Region register : registers) {
            sb.append(register + "\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), OPERATION_NAME, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void alteracao() throws IOException, EndOperationException {
        final String OPERATION_NAME = "Alteração";
        List<Region> registers;
        Region newRegion;

        while (true) {
            registers = new ArrayList<>();
            newRegion = null;

            try {
                int id = Integer.parseInt(requestData(OPERATION_NAME, "Informe o ID da região:"));
                registers = FileManager.readFile();
                for (Region region : registers) {
                    if (id == region.getId()) {
                        newRegion = region;
                        break;
                    }
                }
                if (newRegion == null) {
                    throw new RegisterNotFoundException();
                }
                if (newRegion.isOpen()) {
                    throw new ConnectionRefusedException();
                }
                newRegion.setOpen(true);
                FileManager.writeFile(registers);
                break;
            } catch (EndOperationException e) {
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), OPERATION_NAME, JOptionPane.WARNING_MESSAGE);
            }
        }

        while (true) {
            try {
                String name = requestData(OPERATION_NAME, "Informe o novo nome da região:");
                newRegion.setName(name);
                break;
            } catch (EndOperationException e) {
                newRegion.setOpen(false);
                FileManager.writeFile(registers);
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), OPERATION_NAME, JOptionPane.WARNING_MESSAGE);
            }
        }

        newRegion.setOpen(false);
        FileManager.writeFile(registers);
    }

    private static void remocao() throws EndOperationException, IOException {
        final String OPERATION_NAME = "Remoção";
        List<Region> registers;
        Region newRegion;

        while (true) {
            registers = new ArrayList<>();
            newRegion = null;

            try {
                int id = Integer.parseInt(requestData(OPERATION_NAME, "Informe o ID da região:"));
                registers = FileManager.readFile();
                for (Region region : registers) {
                    if (id == region.getId()) {
                        newRegion = region;
                        break;
                    }
                }
                if (newRegion == null) {
                    throw new RegisterNotFoundException();
                }
                if (newRegion.isOpen()) {
                    throw new ConnectionRefusedException();
                }
                newRegion.setOpen(true);
                FileManager.writeFile(registers);
                break;
            } catch (EndOperationException e) {
                throw e;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), OPERATION_NAME, JOptionPane.WARNING_MESSAGE);
            }
        }

        int shouldRemove = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?",
                OPERATION_NAME, JOptionPane.YES_NO_OPTION);
        if (shouldRemove == 0) {
            registers.remove(newRegion);
            FileManager.writeFile(registers);
        }
    }

    private static String requestData(String title, String message) throws EndOperationException {
        String data = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        if (data == null) {
            throw new EndOperationException();
        }
        return data;
    }
}
