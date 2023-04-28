package decorator.stream.csv;

public enum Separator 
{
	COMMA(','),
	SEMICOLON(';'),
	COLON(':'),
	TAB('\t'),
	SPACE(' '),
	PIPE('|');
	
	//---------------------------------
	private char value = ',';
	
	//---------------------------------
	Separator(char value)
	{
		this.value = value;
	}
	
	//---------------------------------
	public char asChar()
	{
		return this.value;
	}
	
	//---------------------------------
	public String asString()
	{
		return ""+this.value;
	}
};
