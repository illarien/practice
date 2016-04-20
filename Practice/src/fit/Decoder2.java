package fit;

import com.garmin.fit.*;

import java.io.FileInputStream;

public class Decoder2 {

	private static String inputFile = "/Users/newbuyer/git/practice/Practice/src/fit/test.fit";

	private static class Listener implements FileIdMesgListener, UserProfileMesgListener, RecordMesgListener {

		public void onMesg(FileIdMesg mesg) {
			System.out.println("File ID:");

			if (mesg.getType() != null) {
				System.out.print("   Type: ");
				System.out.println(mesg.getType().getValue());
			}

			if (mesg.getManufacturer() != null) {
				System.out.print("   Manufacturer: ");
				System.out.println(mesg.getManufacturer());
			}

			if (mesg.getProduct() != null) {
				System.out.print("   Product: ");
				System.out.println(mesg.getProduct());
			}

			if (mesg.getSerialNumber() != null) {
				System.out.print("   Serial Number: ");
				System.out.println(mesg.getSerialNumber());
			}

			if (mesg.getNumber() != null) {
				System.out.print("   Number: ");
				System.out.println(mesg.getNumber());
			}
			
			
			if (mesg.getTimeCreated() != null) {
				System.out.print("   Time Created: ");
				System.out.println(mesg.getTimeCreated());
			}
			
		}

		public void onMesg(UserProfileMesg mesg) {
			System.out.println("User profile:");

			if ((mesg.getFriendlyName() != null)) {
				System.out.print("   Friendly Name: ");
				System.out.println(mesg.getFriendlyName());
			}

			if (mesg.getGender() != null) {
				if (mesg.getGender() == Gender.MALE)
					System.out.println("   Gender: Male");
				else if (mesg.getGender() == Gender.FEMALE)
					System.out.println("   Gender: Female");
			}

			if (mesg.getAge() != null) {
				System.out.print("   Age [years]: ");
				System.out.println(mesg.getAge());
			}

			if (mesg.getWeight() != null) {
				System.out.print("   Weight [kg]: ");
				System.out.println(mesg.getWeight());
			}
		}
	
		public void onMesg(RecordMesg mesg) {
			System.out.println("Record: " + mesg.getTimestamp().toString() + " HR: " + mesg.getHeartRate() + " Power: " + mesg.getPower());
		}
	}

	public static void main(String[] args) {
		Decode decode = new Decode();
		// decode.skipHeader(); // Use on streams with no header and footer
		// (stream contains FIT defn and data messages only)
		// decode.incompleteStream(); // This suppresses exceptions with
		// unexpected eof (also incorrect crc)
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		Listener listener = new Listener();
		FileInputStream in;

		System.out
				.printf("FIT Decode Example Application - Protocol %d.%d Profile %.2f %s\n",
						Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR,
						Fit.PROFILE_VERSION / 100.0, Fit.PROFILE_TYPE);


		try {
			in = new FileInputStream(inputFile);
		} catch (java.io.IOException e) {
			throw new RuntimeException("Error opening file " + args[0] + " [1]");
		}

//		try {
//			if (!decode.checkFileIntegrity((InputStream) in))
//				throw new RuntimeException("FIT file integrity failed.");
//		} catch (RuntimeException e) {
//			System.err.print("Exception Checking File Integrity: ");
//			System.err.println(e.getMessage());
//			System.err.println("Trying to continue...");
//		} finally {
//			try {
//				in.close();
//			} catch (java.io.IOException e) {
//				throw new RuntimeException(e);
//			}
//		}

//		try {
//			in = new FileInputStream(inputFile);
//		} catch (java.io.IOException e) {
//			throw new RuntimeException("Error opening file " + args[0] + " [2]");
//		}

		mesgBroadcaster.addListener((FileIdMesgListener) listener);
		mesgBroadcaster.addListener((UserProfileMesgListener) listener);
		mesgBroadcaster.addListener((RecordMesgListener) listener);
//		mesgBroadcaster.addListener((MonitoringMesgListener) listener);

		try {
			decode.read(in, mesgBroadcaster); //, mesgBroadcaster);
		} catch (FitRuntimeException e) {
			// If a file with 0 data size in it's header has been encountered,
			// attempt to keep processing the file
//			if (decode.getInvalidFileDataSize()) {
//				decode.nextFile();
//				decode.read(in, mesgBroadcaster, mesgBroadcaster);
//			} else {
//				System.err.print("Exception decoding file: ");
//				System.err.println(e.getMessage());
//
//				try {
//					in.close();
//				} catch (java.io.IOException f) {
//					throw new RuntimeException(f);
//				}
//
//				return;
//			}
		}

		try {
			in.close();
		} catch (java.io.IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Decoded FIT file " + inputFile + ".");
	}
}
