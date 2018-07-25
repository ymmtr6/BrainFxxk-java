package emulator;
import java.util.*;

/**
 * 
 * @author rikuy
 *
 */
public class BFEmulator {
	
	private int[] dseg = new int[1000];
	private int pointer = 0;
	private int[] jump = new int[1000];
	private boolean isSkip = false;
	private int jumpCounter = -1;
	private List<Token> iseg = new ArrayList<>();
	private int index = 0;
	private Scanner scanner = new Scanner(System.in);
	
	public BFEmulator(){
		
	}
	
	public void setIseg(List<Token> iseg){
		this.iseg = iseg;
	}
	
	public boolean next(){
		Token token = iseg.get(index);
		if(token != Token.LOOP_R && isSkip){
			this.isSkip = false;
			index++;
			return false;
		}
		switch(token){
		case DEC:
			pointer--;
			break;
		case END:
			return true;
		case INC:
			pointer++;
			break;
		case INPUT:
			dseg[pointer] = scanner.nextByte();
			break;
		case LOOP_L:
			if(dseg[pointer] == 0){
				this.isSkip = true;
			} else {
				this.jumpCounter++;
				this.jump[jumpCounter] = index;
			}
			break;
		case LOOP_R:
			if(dseg[pointer] != 0){
				index = jump[jumpCounter];
			} else {
				jumpCounter--;
			}
			break;
		case MINUS:
			dseg[pointer]--;
			break;
		case PLUS:
			dseg[pointer]++;
			break;
		case PUT:
			System.out.print((char)dseg[pointer]);
			break;
		default:
			break;
		}
		index++;
		return false;
	}
	
	public String toString(){
		String data = "Dseg:";
		for(int d: dseg){
			data += d;
		}
		data += "\n";
		String p = "Pointer: " + this.pointer + "\n";
		return data + p;
	}
	
	public static void main(String[] args){
		BFEmulator emu = new BFEmulator();
		LexicalAnalyer la = new LexicalAnalyer();
		emu.setIseg(la.helloWorld());

		while(!emu.next());
		System.out.println();
		System.out.println(emu);
	}
	
}
