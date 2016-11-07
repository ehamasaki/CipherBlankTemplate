//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class fileIO {
//	public static void writeDataToFile(String filePath, String data);
//		File outFile = new File (filePath);
//		try (BufferedWriter writer = new BufferedWriter (new FileWriter(outFile))){
//			writer.write(data);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//			
//	
//
//	public static String readFileAsString(String filePath){
//			StringBuilder output = newStringBuilder;
//			
//			try (Scanner scanner = new Scanner (new File (filePath))){
//					while (scanner.hasNext()) {
//							String line = scanner.nextLine();
//							output.append(line);
//							
//					}
//			} catch(IOException e){
//				e.printStackTrace();
//				
//					
//				
//			}
//			return output.toString();
//			
//		}
//	}
//}
