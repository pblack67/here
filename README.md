# here
Coding Assignment for HERE

## Language

I chose Java for the language since it's the most familiar to me and I am the most proficient in it.

## Data Structure

The data structure is a simple list that carries a Set of attributes in it. Only positive responses are stored ("Y") in it. This gives some sparse storage so that the entire market line doesn't have to be stored in memory. This also makes for easy lookup during the filtering process and was the primary reason for using it. The attributes are defined in an enumeration with associated integers to make storage easier.

## Filtering Algorithm

The filtering algorithm is straightforward. For Part I it's looping through the stores looking for a complete match of attributes as well as the distance being under the radius specified. The attribute lookup is constant time since it's doing a set lookup. 

For Part II the algorithm checks to see if any of the criteria match and computes a percentage of the match. This is stored in the results. The distance criteria is then applied to the market as per above. The results are then sorted by match percentage.

## Complexity

The space complexity should be O(N) since the program is storing a linear list as well as a set per market. There isn't data duplication here. 

The search complexity should be O(N) as well since the search only goes through the data once.

## Improvements

I could've read in the data and computed the distance from the point specified during the data loading instead of during the search. This would've made additional searches from the same point faster. Similarly I could've scored the attributes at load time as well so have the highest sorted maps first and then could've quit when the first match(es) occurred. The algorithm isn't scalable. The attribute checks and distance checks could've been multi-threaded to get better throughput. A threadpool Executor or the like could be used. The sorting portion of Part II wasn't ideal and coming up with a faster solution would've been a much better deal than the chosen implementation. If I had more time I would've implemented something more elegant. Also, my haversine algorithm seems to not jive with the sample data I was given. Some checks on the Internet with some other calculators seems to back up the implentation I used. However, something could still be amiss.


