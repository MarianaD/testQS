package system;

import java.util.Comparator;

/**
 * Music Class
 * 
 * Date 30-09-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public class MusicClass implements Music {

	public static final String FORMAT_MP3 = "mp3";
	public static final String FORMAT_WAV = "wav";
	public static final String FORMAT_AIFF = "aiff";

	private String musicName;
	private String artist;
	private int duration;
	private String fileFormat;
	private int rating;

	/**
	 * Music Class Constructor
	 * 
	 * @param musicName
	 *            the music's name
	 * @param artist
	 *            the artist's name
	 * @param duration
	 *            the music's duration
	 * @param fF
	 *            the music's file format
	 * @param rating
	 *            the music's classification
	 */
	public MusicClass(String musicName, String artist, int duration, String fF,
			int rating) {
		this.musicName = musicName;
		this.artist = artist;
		this.duration = duration;
		this.rating = rating;

		if (fF.equalsIgnoreCase(FORMAT_MP3) || fF.equalsIgnoreCase(FORMAT_WAV)
				|| fF.equalsIgnoreCase(FORMAT_AIFF)) {
			this.fileFormat = fF;
		} else {
			this.fileFormat = FORMAT_MP3;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getName()
	 */
	@Override
	public String getName() {
		return this.musicName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getArtist()
	 */
	@Override
	public String getArtist() {
		return this.artist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getDuration()
	 */
	@Override
	public int getDuration() {
		return this.duration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getFormat()
	 */
	@Override
	public String getFormat() {
		return this.fileFormat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getRating()
	 */
	@Override
	public int getRating() {
		return this.rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#equals(system.Music)
	 */
	@Override
	public boolean equals(Music m) {
		System.out.println("- equals music used");
		return (m.getName().equalsIgnoreCase(musicName)
				&& m.getArtist().equalsIgnoreCase(artist) && (m.getDuration() == duration));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#convert(java.lang.String)
	 */
	@Override
	public Music convert(String fileF) {
		return new MusicClass(this.musicName, this.artist, this.duration,
				fileF, this.rating);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Music#getRatingPict()
	 */
	@Override
	public String getRatingPict() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < this.rating; i++) {
			stringBuilder.append("*");
		}
		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + duration;
		result = prime * result
				+ ((musicName == null) ? 0 : musicName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicClass other = (MusicClass) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equalsIgnoreCase(other.artist))
			return false;
		if (duration != other.duration)
			return false;
		if (musicName == null) {
			if (other.musicName != null)
				return false;
		} else if (!musicName.equalsIgnoreCase(other.musicName))
			return false;
		return true;
	}

	/**
	 * Comparator of musics considering the respective rating
	 */
	public static Comparator<Music> MusicRatingComparator = new Comparator<Music>() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Music m1, Music m2) {

			int cmpNames = m1.getName().compareToIgnoreCase(m2.getName());
			if (cmpNames == 0) {
				int cmpArtist = m1.getArtist().compareToIgnoreCase(
						m2.getArtist());
				if (cmpArtist == 0) {
					return m1.getDuration() - m2.getDuration();
				} else {
					return cmpArtist;
				}
			} else {
				return cmpNames;
			}

		}

	};

	@Override
	public String toString() {
		return "MusicClass [musicName=" + musicName + ", artist=" + artist
				+ ", duration=" + duration + ", fileFormat=" + fileFormat
				+ ", rating=" + rating + "]";
	}

}
