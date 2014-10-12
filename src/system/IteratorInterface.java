package system;

/**
 * Iterator's Interface
 * 
 * Date 04-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public interface IteratorInterface {

	/**
	 * checks if there are still other musics to visit. Returns true if next can
	 * still return a music, or false otherwise
	 * 
	 * @return true or false depending whether there is or not other musics
	 */
	boolean hasNext();

	/**
	 * If there are still more musics to visit, return the current music and
	 * advance to the next one. If no more musics are available, return null
	 * 
	 * @return the next music
	 */
	Music next();
}
