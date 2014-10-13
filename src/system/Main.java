package system;

public class Main {

	public static void main(String[] args) {

		// ***************************************
		// Test Music Class
		// ***************************************

		Music m1 = new MusicClass("MusicaA", "Mariana", 2,
				MusicClass.FORMAT_MP3, 3);
		Music m2 = new MusicClass("MusicaB", "Bu", 2, "xxa", 3);

		System.out.println("TEST MUSIC\n");
		System.out.println(m1.toString());
		System.out.println(m2.toString());

		Music m3 = m2.convert(MusicClass.FORMAT_WAV);

		System.out.println("Musica convertida");
		System.out.println(m3.toString());

		System.out.println("Are m2 and m3 equal? " + m2.equals(m3));

		Music m4 = new MusicClass("MusicaB", "Mariana", 2,
				MusicClass.FORMAT_AIFF, 4);

		System.out.println("Are m1 and m3 equal? " + m1.equals(m4) + "\n\n");

		// ***************************************
		// Test Playlist Class
		// ***************************************

		System.out.println("TEST PLAYLIST\n");

		Music a1 = new MusicClass("MusicaA1", "Marte", 3, "mp3", 3);
		Music a2 = new MusicClass("MusicaA1", "marte", 3,
				MusicClass.FORMAT_AIFF, 4);
		Music a3 = new MusicClass("MusicaA3", "Marte", 5,
				MusicClass.FORMAT_AIFF, 4);

		Playlist p = new PlaylistClass("Planetas", 7);

		System.out.println("Playlist Jupiter creater. Maximum size 6");

		// Test if add correctly
		System.out.println("\nMusicA1 added? " + p.addMusic(a1));
		System.out.println("MusicA2 added? " + p.addMusic(a2));

		Music b0 = new MusicClass("MusicaB1", "Mercurio", 3,
				MusicClass.FORMAT_AIFF, 1);
		Music b1 = new MusicClass("MusicaB1", "Mercurio", 3,
				MusicClass.FORMAT_AIFF, 1);
		Music b2 = new MusicClass("MusicaB2", "Mercurio", 1,
				MusicClass.FORMAT_AIFF, 2);
		Music b3 = new MusicClass("MusicaB3", "Mercurio", 7,
				MusicClass.FORMAT_AIFF, 2);
		Music b4 = new MusicClass("MusicaB4", "Mercurio", 6,
				MusicClass.FORMAT_AIFF, 2);
		Music c1 = new MusicClass("MC1", "Jupiter", 7, "wav", 5);
		Music c2 = new MusicClass("MC2", "Jupiter", 1, MusicClass.FORMAT_AIFF,
				1);

		System.out.println("\nMusicA1 added? " + p.addMusic(a3));

		// Test if it will not add two equal musics
		System.out.println("\nMusicB1 added? " + p.addMusic(b1));
		System.out.println("MusicB1 added again? " + p.addMusic(b0));

		System.out.println("\nNumber of musics of Marte "
				+ p.numMusics("Marte"));
		System.out.println("Number of musics of Mercurio "
				+ p.numMusics("Mercurio"));
		System.out.println("Number of musics of Jupiter "
				+ p.numMusics("Jupiter"));

		// Check productive artist
		// Because there are 2 musics of Marte and 1 music of Mercurio,
		// it will checks only the number of musics
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
		// of Jupiter, Mercurio wins :)
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
			System.out.println(tmp.toString());
		}

		System.out.println("\nCurrent music is " + p.getName());

		System.out.println("\n\nBackward: ");
		for (int i = 0; i < p.getSize(); i++) {
			tmp = p.backwardMusic();
			System.out.println(tmp.toString());
		}

		System.out.println("\nCurrent music is " + p.getName());

		System.out.println("\nNew musics added!");
		Music d1 = new MusicClass("MusicaA3", "Jupiter", 7, "wav", 5);
		Music d2 = new MusicClass("MusicaA3", "Jupiter", 3,
				MusicClass.FORMAT_AIFF, 1);
		p.addMusic(d1);
		p.addMusic(d2);

		Music d3 = new MusicClass("A rapariga que bla bla", "Jupiter", 7,
				"wav", 5);
		Music d4 = new MusicClass("Bola no ar", "Jupiter", 3,
				MusicClass.FORMAT_AIFF, 1);
		p.addMusic(d3);
		p.addMusic(d4);

		System.out.println("\n\nOrdered: ");
		for (int i = 0; i < p.getSize(); i++) {
			tmp = p.nextOrderedMusic();
			System.out.println(tmp.toString());
		}

		System.out.println("\nCurrent music is " + p.getName());

	}

}
