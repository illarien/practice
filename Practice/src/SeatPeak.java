import java.util.ArrayList;

/**
 * seat pick algorithm (Implementation of a method that will
 * return the list of available tickets in the system given input as
 * number of tickets.).
 */
public class SeatPeak {
	
	private static class Ticket {
		private int row, seat;
		private boolean sold = false;
		
		public Ticket(int seat) {
//			this.row = row;
			this.seat = seat;
		}
		public boolean isSold() {
			return sold;
		}
		public void sell() {
			sold = true;
		}
	}

	private static class Row {
		// implement Comparable by avaliable Tickets
		int nOfSeats;
		int rowNumber;
		
		ArrayList<Ticket> seats;
		
		public Row (int nOfSeats) {
			this.seats = new ArrayList<>();
			for (int i = 0; i < nOfSeats; i++) {
				seats.add(new Ticket(i));
			}
		}
	}
	
	private static class Hall {
		int nOfRows = 10;
		int seatsInRow = 20;
		ArrayList<Row> rows;
		
		public Hall (int nRows, int nSeats) {
			this.nOfRows = nRows;
			this.seatsInRow = nSeats;
			this.rows = new ArrayList<Row>(nOfRows);
			for (int i = 0; i < nOfRows; i++) {
				rows.add(new Row(seatsInRow));
			}
		}
		
		public Hall () {
			this.rows = new ArrayList<Row>(nOfRows);
			for (int i = 0; i < nOfRows; i++) {
				rows.add(new Row(seatsInRow));
			}
		}
		
		public ArrayList<Ticket> getTickets(int nOfTickets) {
			ArrayList<Ticket> result = new ArrayList<>(nOfTickets);
//			Row row = getLowestRow(nOfTickets);
			
			return result;
		}
		
//		private Row getLowestRow(int nOfTickets) {
//			Row tmpRow = rows.get(0);
//			for (Row row: rows) {
//				if (row.getAvaliableSeats() >= nOfTickets && ) {
//					
//				}
//			}
//		}
		
		// sort roes by N of avaliable tickets
		
	}
	
	public static void main(String[] args) {
		Hall hall = new Hall(9, 19);
		System.out.println(hall.rows.size());
		System.out.println(hall.rows.get(0).seats.size());

		System.out.println(hall.getTickets(5));
	}
}