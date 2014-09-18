package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MapParser {

	private File map;
	
	public MapParser(File map){
		this.map=map;
	}
	
	public List<String> readFile() {
		List<String> result = new ArrayList<String>();
		try {

			FileReader fr = new FileReader(map);
			BufferedReader br = new BufferedReader(fr);

			for (String line = br.readLine(); line != null; line = br
					.readLine()) {
				result.add(line);
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
