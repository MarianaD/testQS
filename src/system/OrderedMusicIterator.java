/**
 * 
 */
package system;

import java.util.*;

/**
 * Foward Music Iterator
 * 
 * Date 04-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public class OrderedMusicIterator implements IteratorInterface {

	private Iterator<Music> it;

	/**
	 * Constructor of Ordered Music Interator Creates an iterator from the
	 * playlist, receiving the playlist as an argument
	 * 
	 * @param playlist
	 *            list of musics to iterate
	 */
	public OrderedMusicIterator(Playlist playlist) {
		List<Music> tmp = new LinkedList<Music>(playlist.getPlaylist());
		Collections.sort(tmp, MusicClass.MusicRatingComparator);

		it = tmp.listIterator();
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
