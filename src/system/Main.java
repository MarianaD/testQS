package system;

public class Main {

	public static void main(String[] args) {

		// ***************************************
		// Test Music Class
		// ***************************************

		
		/*
		Music m1 = new MusicClass("MusicaA", "Mariana", 2, "mp3", 3);

		System.out.println("TEST MUSIC\n");
		System.out.println("Name: " + m1.getName() + "\nArtist: "
				+ m1.getArtist() + "\nDuration: " + m1.getDuration()
				+ "\nFormat: " + m1.getFormat() + "\nRating: " + m1.getRating()
				+ "\nRatingPict: " + m1.getRatingPict());
		Music m2 = m1.convert("wav");

		System.out.println("Musica convertida");
		System.out.println("F1: " + m1.getFormat() + " F2: " + m2.getFormat());

		System.out.println("Are m1 and m2 equal? " + m1.equals(m2));

		Music m3 = new MusicClass("MusicaB", "Mariana", 2, "flac", 4);

		System.out.println("Are m1 and m3 equal? " + m1.equals(m3) + "\n\n");

		*/
		
		// ***************************************
		// Test Playlist Class
		// ***************************************

		System.out.println("TEST PLAYLIST\n");

		Music a1 = new MusicClass("MusicaA1", "Marte", 2, "mp3", 3);
		Music a2 = new MusicClass("MusicaA2", "Marte", 5, "flac", 4);
		Music b1 = new MusicClass("MusicaB1", "Mercurio", 3, "flac", 1);
		Music b2 = new MusicClass("MusicaB2", "Mercurio", 1, "flac", 2);
		Music b3 = new MusicClass("MusicaB3", "Mercurio", 7, "flac", 2);
		Music b4 = new MusicClass("MusicaB4", "Mercurio", 6, "flac", 2);
		Music c1 = new MusicClass("MC1", "Jupiter", 7, "wav", 5);
		Music c2 = new MusicClass("MC2", "Jupiter", 1, "flac", 1);

		Playlist p = new PlaylistClass("Planetas", 7);

		System.out.println("Playlist Jupiter creater. Maximum size 6");

		// Test if add correctly
		System.out.println("\nMusicA1 added? " + p.addMusic(a1));
		System.out.println("MusicA2 added? " + p.addMusic(a2));

		// Test if it will not add two equal musics
		System.out.println("\nMusicB1 added? " + p.addMusic(b1));
		System.out.println("MusicB1 added again? " + p.addMusic(b1));

		System.out.println("\nNumber of musics of Marte "
				+ p.numMusics("Marte"));
		System.out.println("Number of musics of Mercurio "
				+ p.numMusics("Mercurio"));
		System.out.println("Number of musics of Jupiter "
				+ p.numMusics("Jupiter"));

		// Check productive artist
		// Because there are 2 musics of Marte and 2 musics of Mercurio,
		// it will check the longest time, so Marte wins :)
		System.out.println("\nWho is the most productive artist? "
				+ p.mostProductiveArtist());

		System.out.println("\nHow long has this playlist? " + p.getDuration());
		System.out.println("How many songs has the playlist? " + p.getSize());

		// Test if limited size is respected
		System.out.println("\nMusicB2 added? " + p.addMusic(b2));
		System.out.println("MusicB3 added? " + p.addMusic(b3));
		System.out.println("MusicB4 added? " + p.addMusic(b4));
		System.out.println("MusicC1 added? " + p.addMusic(c1));
		System.out.println("MusicC2 added? " + p.addMusic(c2)); // this should
																// not be added

		System.out.println("\nThis playlist contains MusicA1? "
				+ p.contains(a1));

		System.out.println("\nNumber of musics of Jupiter "
				+ p.numMusics("Jupiter"));

		System.out.println("\nHow long has this playlist? " + p.getDuration());
		System.out.println("How many songs has the playlist? " + p.getSize());

		// Check productive artist
		// Because there are 2 musics of Marte, 4 musics of Mercurio and 1 music
		// of Jupiter
		// so Mercurio wins :)
		System.out.println("\nWho is the most productive artist? "
				+ p.mostProductiveArtist());

		System.out.println("\nDeleted MusicA1 " + p.deleteMusic(a1));
		System.out.println("Deleted MusicB1 " + p.deleteMusic(b1));
		System.out.println("Deleted MusicB4 " + p.deleteMusic(b4));
		System.out.println("Deleted MusicB2 " + p.deleteMusic(b2));

		System.out.println("\nThis playlist contains MusicA1? "
				+ p.contains(a1));

		// Check productive artist
		// Because there are 1 musics of Marte, 1 musics of Mercurio, and 1
		// music of Jupiter
		// Between the 3, Mercurio and Jupiter has the longest time
		// But Jupiter has a lower name than Mercurio, so Jupiter wins :)
		System.out.println("\nWho is the most productive artist? "
				+ p.mostProductiveArtist());

		System.out.println("\nHow long has this playlist? " + p.getDuration());
		System.out.println("How many songs has the playlist? " + p.getSize());

		// ***************************************
		// Test Iterators
		// ***************************************

		System.out.println("\n\nTEST ITERATORS\n");

		System.out.println("\nForward: ");
		Music tmp;
		for (int i = 0; i < p.getSize(); i++) {
			tmp = p.forwardMusic();
			System.out.println("Music: " + tmp.getName() + " Artist: "
					+ tmp.getArtist() + " Duration: " + tmp.getDuration()
					+ "\nFormat: " + tmp.getFormat() + "Rating: "
					+ tmp.getRating() + " RatingPic: " + tmp.getRatingPict());
		}

		System.out.println("\nCurrent music is " + p.getName());

		System.out.println("\n\nBackward: ");
		for (int i = 0; i < p.getSize(); i++) {
			tmp = p.backwardMusic();
			System.out.println("Music: " + tmp.getName() + " Artist: "
					+ tmp.getArtist() + " Duration: " + tmp.getDuration()
					+ "\nFormat: " + tmp.getFormat() + "Rating: "
					+ tmp.getRating() + " RatingPic: " + tmp.getRatingPict());
		}

		System.out.println("\nCurrent music is " + p.getName());

		System.out.println("\n\nOrdered: ");
		for (int i = 0; i < p.getSize(); i++) {
			tmp = p.nextOrderedMusic();
			System.out.println("Music: " + tmp.getName() + " Artist: "
					+ tmp.getArtist() + " Duration: " + tmp.getDuration()
					+ "\nFormat: " + tmp.getFormat() + "Rating: "
					+ tmp.getRating() + " RatingPic: " + tmp.getRatingPict());
		}

		System.out.println("\nCurrent music is " + p.getName());

	}

}
