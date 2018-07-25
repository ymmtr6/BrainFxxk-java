package emulator;

public enum Token {
	INC(0), // >
	DEC(1), // <
	PLUS(2), // +
	MINUS(3), // -
	PUT(4), // .
	INPUT(5), // ,
	LOOP_L(6), // [
	LOOP_R(7), // ]
	END(8);
	
	private final int id;
	
	Token(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
}
