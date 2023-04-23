/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package csvwriter;

/**
 *
 * @author andre
 */
public enum Separator {
    
    COMMA(','), SEMICOLON(';'),COLON(':'),TAB('\t'),SPACE(' '),PIPE('|');
    
    private char value = ',';
    
    Separator(char value){
        this.value = value;
    }
    public char asChar(){
        return value;
    }
    public String asString(){
        return ""+value;
    }
    
}
