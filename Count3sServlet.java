import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;

/* Count3sServlet */
public class Count3sServlet {
	
	public static void main(String[] args) {
		
		int count = 0;
		int readValue = 0;
		File file = new File("threesData.bin");
                FileInputStream fin;
		BufferedInputStream buffin;
		DataInputStream in = null;

		try {
			// create FileInputStream object
			fin = new FileInputStream(file);
			buffin = new BufferedInputStream(fin);

			in = new DataInputStream(buffin);
			while(in.available() > 0) {
				readValue = in.readInt();
				if (readValue == 3) {
					count++;
				}
			}
			System.out.println("Count3sServlet Response: " + count);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//catch (EOFException eofe) {
		//	System.out.println("End of file " + eofe);
		//}
		//catch (IOException ioe) {
		//	System.out.println("Exception while reading file " + ioe);
		//}
		finally {
			// close the streams using close method
			try {
				if (in.available() > 0) {
					in.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error while closing stream: " + ioe);
			}
		} 
	}
}
