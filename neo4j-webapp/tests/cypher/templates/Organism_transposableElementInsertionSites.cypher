MATCH (transposableelementinsertionsite :TransposableElementInsertionSite),
(transposableelementinsertionsite)-[]-(transposableelementinsertionsite_organism :organism),
(transposableelementinsertionsite)-[]-(transposableelementinsertionsite_chromosomelocation :chromosomeLocation),
(transposableelementinsertionsite)-[]-(transposableelementinsertionsite_chromosome :chromosome),
(transposableelementinsertionsite)-[]-(transposableelementinsertionsite_cytolocation :cytoLocation)

WHERE transposableelementinsertionsite_organism.name = 'Drosophila melanogaster'
RETURN transposableelementinsertionsite.primaryIdentifier,
transposableelementinsertionsite_chromosome.primaryIdentifier,
transposableelementinsertionsite_chromosomelocation.start,
transposableelementinsertionsite_chromosomelocation.end,
transposableelementinsertionsite_chromosomelocation.strand
ORDER BY transposableelementinsertionsite.primaryIdentifier ASC
