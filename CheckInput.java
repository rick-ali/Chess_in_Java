package chess;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {

	public boolean checkCoordinateValidity(String input){
		Pattern pattern = Pattern.compile("^[1-8][a-h]$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) return true;
		return false;
	}
}
