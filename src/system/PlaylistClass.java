package system;

import java.util.*;

/**
 * Playlist Class
 * 
 * Date 03-10-2014
 * 
 * @version 1
 * 
 * @author Mariana Diogo
 *
 */
public class PlaylistClass implements Playlist {

	public static final int MAX_SIZE = 256;

	//private String currentMusic;
	private int size;
	private String name;
	private int duration;

	private String artist;
	private boolean addedOrRemovedMusics;

	private List<Music> playlist;

	private IteratorInterface fM;
	private IteratorInterface bM;
	private IteratorInterface oM;

	/**
	 * Build a new PlayList, with the name. The n parameter represents the
	 * maximum number of musics which the playlist can store.
	 * 
	 * @param name
	 *            playlist's name
	 * @param n
	 *            playlist's size
	 */
	public PlaylistClass(String name, int n) {
		this.name = name;
		this.size = n;

		this.playlist = new LinkedList<Music>();
		this.duration = 0;
		this.addedOrRemovedMusics = false;

	}

	/**
	 * Build a new PlayList, with the name. The n parameter represents the
	 * maximum number of musics which the playlist can store. The playlist
	 * maximum size is 256 musics
	 * 
	 * @param name
	 *            playlist's name
	 */
	public PlaylistClass(String name) {
		this.name = name;
		this.size = MAX_SIZE;

		this.playlist = new LinkedList<Music>();
		this.duration = 0;
		this.addedOrRemovedMusics = false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#getSize()
	 */
	@Override
	public int getSize() {
		return this.playlist.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#getDuration()
	 */
	@Override
	public int getDuration() {
		return this.duration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#contains(system.Music)
	 */
	@Override
	public boolean contains(Music m) {
		return this.playlist.contains(m);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#addMusic(system.Music)
	 */
	@Override
	public boolean addMusic(Music m) {

		// check if playlist is full
		if (this.playlist.size() == this.size) {
			return false;
			// check if playlist already has that music
		} else if (contains(m)) {
			return false;
		} else {
			this.duration += m.getDuration();
			this.playlist.add(m);
			this.addedOrRemovedMusics = true;
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#deleteMusic(system.Music)
	 */
	@Override
	public boolean deleteMusic(Music m) {
		this.duration -= m.getDuration();
		addedOrRemovedMusics = true;
		return this.playlist.remove(m);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#numMusics(java.lang.String)
	 */
	@Override
	public int numMusics(String artist) {
		int counter = 0;
		for (Music m : playlist) {
			if (m.getArtist().equals(artist)) {
				counter++;
			}
		}
		return counter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#mostProductiveArtist()
	 */
	@Override
	public String mostProductiveArtist() {
		// Check if no changes occured in the playlist => the most productive
		// artist is the same
		if (artist != null && !this.addedOrRemovedMusics) {
			return artist;
		} else {
			// Check who is the most productive artist
			Map<String, ArtistInfo> tmp = new HashMap<String, ArtistInfo>();

			for (Music m : this.playlist) {

				ArtistInfo aI = tmp.get(m.getArtist());
				if (aI == null) {
					// Add new
					aI = new ArtistInfo(m.getDuration());
				} else {
					// Update Information
					if (aI.getLongestDuration() < m.getDuration()) {
						aI.setLongestDuration(m.getDuration());
					}
					aI.incrementNrMusics();
				}
				tmp.put(m.getArtist(), aI);
			}

			// order everything and get the new artist
			this.artist = sortByValue(tmp);
			this.addedOrRemovedMusics = false;

			return artist;

		}
	}

	public static String sortByValue(Map<String, ArtistInfo> map) {
		List<Map.Entry<String, ArtistInfo>> list = new LinkedList<Map.Entry<String, ArtistInfo>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, ArtistInfo>>() {
			public int compare(Map.Entry<String, ArtistInfo> o1,
					Map.Entry<String, ArtistInfo> o2) {

				// First, it will evaluate the number of musics of the both
				// artists
				int nrM = o2.getValue().getNrMusics()
						- o1.getValue().getNrMusics();
				if (nrM > 0) {
					return 1;
				} else if (nrM < 0) {
					return -1;
				} else {
					// If this not enough, it will evaluate the longest duration
					int sizeP = o2.getValue().getLongestDuration()
							- o1.getValue().getLongestDuration();
					if (sizeP > 0) {
						return 1;
					} else if (sizeP < 0) {
						return -1;
					} else {
						// And finally, as last resource, it will compare in
						// lexicographic terms the lower artist
						return o1.getKey().compareToIgnoreCase(o2.getKey());
					}
				}

			}
		});

		/*
		 * Map<String, ArtistInfo> result = new LinkedHashMap<String,
		 * ArtistInfo>();
		 * 
		 * for (Map.Entry<String, ArtistInfo> entry : list) { result.put(
		 * entry.getKey(), entry.getValue() ); }
		 */

		return list.get(0).getKey();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#getPlaylist()
	 */
	@Override
	public List<Music> getPlaylist() {
		return playlist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#forwardMusic()
	 */
	@Override
	public Music forwardMusic() {
		Music m = null;
		if (this.fM == null) {
			this.fM = new ForwardMusicIterator(this);
		}
		if (fM.hasNext()) {
			m = fM.next();
			//this.currentMusic = m.getName();
		} else {
			// If found the end of the iterator, it goes back to the beginning
			this.fM = new ForwardMusicIterator(this);
			m = fM.next();
			//this.currentMusic = m.getName();
		}
		return m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#backwardMusic()
	 */
	@Override
	public Music backwardMusic() {
		Music m = null;
		if (this.bM == null) {
			this.bM = new BackwardMusicIterator(this);
		}
		if (bM.hasNext()) {
			m = bM.next();
			//this.currentMusic = m.getName();
		} else {
			// If found the end of the iterator, it goes back to the beginning
			this.bM = new BackwardMusicIterator(this);
			m = bM.next();
			//this.currentMusic = m.getName();
		}
		return m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see system.Playlist#nextOrderedMusic()
	 */
	@Override
	public Music nextOrderedMusic() {
		Music m = null;
		if (this.oM == null) {
			this.oM = new OrderedMusicIterator(this);
		}
		if (oM.hasNext()) {
			m = oM.next();
			//this.currentMusic = m.getName();
		} else {
			// If found the end of the iterator, it goes back to the beginning
			this.bM = new OrderedMusicIterator(this);
			m = bM.next();
			//this.currentMusic = m.getName();
		}
		return m;
	}

	/**
	 * Auxiliary Class with information of a specific artist in the playlist
	 * 
	 * Date 04-10-2014
	 * 
	 * @version 1
	 * 
	 * @author Mariana
	 *
	 */
	private class ArtistInfo {

		private int longestDuration;
		private int nrMusics;

		public ArtistInfo(int longestDuration) {
			this.longestDuration = longestDuration;
			this.nrMusics = 1;
		}

		/* *********************************************
		 *             Getters and Setters
		 *********************************************/

		/**
		 * Get the duration of the longest music of this artist in the playlist
		 * 
		 * @return longest duration
		 */
		public int getLongestDuration() {
			return longestDuration;
		}

		/**
		 * Change the longest duration of the artist
		 * 
		 * @param longestDuration
		 *            the duration of the longest music
		 */
		public void setLongestDuration(int longestDuration) {
			this.longestDuration = longestDuration;
		}

		/**
		 * Get the number of musics of this artist in the playlist
		 * 
		 * @return number of musics
		 */
		public int getNrMusics() {
			return nrMusics;
		}

		/**
		 * Set the number of musics of this artist in the playlist
		 * 
		 * @param nrMusics
		 *            number of musics
		 */
		public void incrementNrMusics() {
			this.nrMusics++;
		}

	}

}
