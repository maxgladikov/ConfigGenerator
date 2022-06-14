package utils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class ProcessorCSV {

	
	
	public static void write(String address,String toBeWrite) {
    try (PrintWriter writer = new PrintWriter(address)) {



      writer.write(toBeWrite);

      System.out.println("done!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
	}
	
	public static List<List<String>> read(String name) throws IOException {
	
	List<List<String>> records = new ArrayList<>();
	try (BufferedReader br = new BufferedReader(new FileReader(name))) {
	    String line;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(",");
	        records.add(Arrays.asList(values));
	    	}
		}
	return records;
	}
	public static List<List<String>> readUTF(String path) throws IOException {
		List<List<String>> records = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(path);
			       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			       BufferedReader reader = new BufferedReader(isr)
			  ) {

			      String str;
			      while ((str = reader.readLine()) != null) {
			         records.add(Arrays.asList(str.split(",")));
			      }

			  } catch (IOException e) {
			      e.printStackTrace();
			  }
		return records;
	}
	
	
	public static void removeP2(String origin,String dest) throws IOException {
		List<List<String>> file=read(origin);
		List<String> result=new ArrayList<String>();
		for (List<String> list : file) {
			if(list.get(0).contains("_P2")) {
				continue;
			}
			String item=list.get(0)+"\n";
			result.add(item);
		}
		
		write(dest,result.toString());
	}
	
	

}
