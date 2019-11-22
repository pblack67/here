package ord.peb.here;

enum ATTRIBUTES {
	    CREDIT (0),
	    WIC (1),
	    WICCASH (2),
	    SFMNNP (3),
	    SNAP (4),
	    ORGANIC (5),
	    BAKEDGOODS (6),
	    CHEESE (7),
	    CRAFTS (8),
	    FLOWERS (9),
	    EGGS (10),
	    SEAFOOD (11),
	    HERBS (12),
	    VEGETABLES (13),
	    HONEY (14),
	    JAMS (15),
	    MAPLE (16),
	    MEAT (17),
	    NURSERY (18),
	    NUTS (19),
	    PLANTS (20),
	    POULTRY (21),
	    PREPARED (22),
	    SOAP (23),
	    TREES (24),
	    WINE (25),
	    COFFEE (26),
	    BEANS (27),
	    FRUITS (28),
	    GRAINS (29),
	    JUICES (30),
	    MUSHROOMS (31),
	    PETFOOD (32),
	    TOFU (33),
	    WILDHARVESTED (34);
		
		private int number;

		ATTRIBUTES(int number) {
	        this.number = number;
	    }

	    public int getNumber() {
	        return number;
	    }
}
