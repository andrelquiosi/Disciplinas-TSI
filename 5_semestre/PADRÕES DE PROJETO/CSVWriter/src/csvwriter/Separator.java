
package csvwriter;

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
