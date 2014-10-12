/**
 * 
 */
package system;

import java.util.*;

/**
 * Backward Music Iterator
 * 
 * Date 04-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public class BackwardMusicIterator implements IteratorInterface {

	private Iterator<Music> it;

	/**
	 * Constructor of Backward Music Interator Creates an iterator from the
	 * playlist, receiving the playlist as an argument
	 * 
	 * 
	 * @param playlist
	 *            list of musics to iterate
	 */
	public BackwardMusicIterator(Playlist playlist) {
		this.it = ((LinkedList<Music>) playlist.getPlaylist())
				.descendingIterator();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Iterator#next()
	 */
	@Override
	public Music next() {
		return it.next();
	}

}
