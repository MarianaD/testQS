package system;

/**
 * Music Interface
 * 
 * Date 30-09-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public interface Music {

	/**
	 * Gets the music name;
	 * 
	 * @return name of the music
	 */
	String getName();

	/**
	 * Gets the artist’s name of this music;
	 * 
	 * @return artist
	 */
	String getArtist();

	/**
	 * Gets the music’s duration
	 * 
	 * @return duration
	 */
	int getDuration();

	/**
	 * Gets the music’s file format
	 * 
	 * @return file format
	 */
	String getFormat();

	/**
	 * Gets the music’s rating
	 * 
	 * @return rating
	 */
	int getRating();

	/**
	 * Checks if two musics are similar. Assume both are similar if they share
	 * the same properties values
	 * 
	 * @param m
	 *            music to compare
	 * @return true or false depending if the musics are or not similar
	 */
	boolean equals(Music m);

	/**
	 * : Returns a new object Music similar in all other properties to the
	 * current one, except in the file format, which should be replaced by
	 * fileFormat. The object executing the convert operation must not be
	 * changed.
	 * 
	 * @param fileFormat
	 *            the music's file format
	 * @return Music with the new file format
	 */
	Music convert(String fileFormat);

	/**
	 * returns a String with a particular number of starts (character “*”) equal
	 * to the music's classification. For example, if the music's classification
	 * is 3, this operation should return the string “***”.
	 * 
	 * @return the music's classification
	 */
	String getRatingPict();

}
