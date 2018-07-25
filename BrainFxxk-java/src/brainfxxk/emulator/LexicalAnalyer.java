package brainfxxk.emulator;
import java.util.*;

/**
 * 
 * @author riku
 *
 */
public class LexicalAnalyer {
	
	/**
	 * get TokenArrays;
	 * @param str String
	 * @return List<Token>
	 */
	public List<Token> parse(String str){
		ArrayList<Token> list = new ArrayList<>();
		for(int i= 0; i < str.length(); i++){
			Token t = getToken(str.charAt(i));
			if(t != null)
				list.add(t);
		}
		return list;
	}

	/**
	 * test method.(hello world)
	 * @return List<Token>
	 */
	public List<Token> helloWorld() {
		String cord = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.[-]>++++++++[<++++>-]<.>+++++++++++[<+++++>-]<.>++++++++[<+++>-]<.+++.------.--------.[-]>++++++++[<++++>-]<+.[-]++++++++++.\0";
		return parse(cord);
	}

	/**
	 * trans token.
	 * @param c	character
	 * @return Token
	 */
	public Token getToken(char c) {
		switch (c) {
		case '>':
			return Token.INC;
		case '<':
			return Token.DEC;
		case '+':
			return Token.PLUS;
		case '-':
			return Token.MINUS;
		case '.':
			return Token.PUT;
		case ',':
			return Token.INPUT;
		case '[':
			return Token.LOOP_L;
		case ']':
			return Token.LOOP_R;
		case '\0':
			return Token.END;
		default:
			return null;
		}
	}
}
