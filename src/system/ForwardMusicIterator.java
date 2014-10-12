/**
 * 
 */
package system;

import java.util.*;

/**
 * Foward Music Iterator
 * 
 * Gives the next music in the playlist
 * 
 * Date 04-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public class ForwardMusicIterator implements IteratorInterface {

	private ListIterator<Music> it;

	/**
	 * Constructor of Foward Music Interator Creates an iterator from the
	 * playlist, receiving the playlist as an argument
	 * 
	 * @param playlist
	 *            list of musics to iterate
	 */
	public ForwardMusicIterator(Playlist playlist) {
		this.it = ((LinkedList<Music>) playlist.getPlaylist()).listIterator(0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.it.hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Iterator#next()
	 */
	@Override
	public Music next() {
		// TODO Auto-generated method stub
		return this.it.next();
	}

}
