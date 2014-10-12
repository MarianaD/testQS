package system;

import java.util.List;

/**
 * Playlist Interface
 * 
 * Date 03-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public interface Playlist {

	/**
	 * Returns the name of the current music If no music was added to the
	 * playlist, it returns null
	 * 
	 * @return music's name
	 */
	String getName();

	/**
	 * Returns the number of musics in the playlist
	 * 
	 * @return size of the playlist
	 */
	int getSize();

	/**
	 * Returns the total playing time of the musics in the playlist.
	 * 
	 * @return duration total time of the playlist
	 */
	int getDuration();

	/**
	 * Returns true if music m belongs to the playlist, or false otherwise
	 * 
	 * @param m
	 *            - the music
	 * @return true or false depending if the music belongs or not to this
	 *         playlist
	 */
	boolean contains(Music m);

	/**
	 * Adds music m to the playlist, if possible, returning true. If the music
	 * is already in the playlist, or the playlist is full, the operation does
	 * nothing and returns false.
	 * 
	 * @param m
	 *            the music to add
	 * @return true or false depending if the music was or not added
	 */
	boolean addMusic(Music m);

	/**
	 * Deletes music m from the playlist, and returns true, if the music was
	 * there to be deleted. Otherwise, the operation does nothing and returns
	 * false
	 * 
	 * @param m
	 *            the music to delete
	 * @return true or false depending if the music was or not deleted
	 */
	boolean deleteMusic(Music m);

	/**
	 * Returns the number of musics within the playlist which are performed by a
	 * particular artist.
	 * 
	 * @param artist
	 *            the artist's name
	 * @return number of musics for the specified artist
	 */
	int numMusics(String artist);

	/**
	 * Returns the artist with the highest number of musics in the playlist. In
	 * case of tie, it returns the tied artist with the longest music in the
	 * playlist. If the tie still persists, it returns the artist with a lower
	 * name, with respect to the lexicographic comparison of names, ignoring
	 * differences between caps and no caps
	 * 
	 * @return name of the artist
	 */
	String mostProductiveArtist();

	/**
	 * Gets the playlist
	 * 
	 * @return list of musics
	 */
	List<Music> getPlaylist();

	/**
	 * Gets the next music if the user moves forward
	 * 
	 * @return next music
	 */
	Music forwardMusic();

	/**
	 * Gets the next music if the user moves backward
	 * 
	 * @return next music
	 */
	Music backwardMusic();

	/**
	 * Gets the next music with playlist ordered by rating
	 * 
	 * @return next music
	 */
	Music nextOrderedMusic();

}
