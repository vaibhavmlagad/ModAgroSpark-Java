-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 09:08 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `modagrospark`
--

-- --------------------------------------------------------

--
-- Table structure for table `diseases`
--

CREATE TABLE IF NOT EXISTS `diseases` (
  `id` int(10) NOT NULL,
  `disease_name` varchar(20) NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT 'Not Specified',
  `temp_from` int(10) NOT NULL,
  `temp_to` int(10) NOT NULL,
  `hum_from` int(10) NOT NULL,
  `hum_to` int(10) NOT NULL,
  `moist_from` int(10) NOT NULL,
  `moist_to` int(10) NOT NULL,
  `plant_affected` varchar(200) DEFAULT 'Not Available',
  `symptoms` varchar(500) DEFAULT 'Not Available',
  `preventions` varchar(200) DEFAULT 'Not Available'
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diseases`
--

INSERT INTO `diseases` (`id`, `disease_name`, `type`, `temp_from`, `temp_to`, `hum_from`, `hum_to`, `moist_from`, `moist_to`, `plant_affected`, `symptoms`, `preventions`) VALUES
(1, 'Cankers', 'Bacterial', 25, 30, 60, 85, 59, 78, 'Woody Plants\r\n', 'Round-to-irregular sunken, swollen, flattened, cracked, discoloured, or dead areas on the stems (canes), twigs, limbs, or trunk', '1)Protective Wrap\r\n2)Liquid Copper\r\n3)Plant Doctor\r\n4)Tree Pruning Sealer'),
(2, 'Damping Off', 'Pathogenic', 24, 30, 50, 70, 78, 87, 'All Types of Plants', 'Killed seedlings, Seedling stems become water soaked and thin, almost thread like, where infected, Young leaves wilt and turn green-gray to brown, Roots are absent, stunted or have grayish-brown sunken spots', '1)Ridomil-Fungicide\r\n2)Rakshak Pseudomonas'),
(4, 'Downy Mindw', 'Horticultural', 28, 31, 60, 85, 74, 88, '1) Grains,\r\n2) Alfalfa,\r\n3) Onions,\r\n4) Cucumbers', 'Leaf curl, leaf drop, cleistothecia, chlorotic, infected fruit and flowers\r\n', '1) Protective wrap \r\n2) Liquid copper \r\n3) Pruning Saw \r\n4) Plant doctor\r\n'),
(5, 'Ergot', 'Fungal', 25, 35, 72, 85, 60, 88, '1) Rye,\r\n2) Barley,\r\n3) Wheat and other grasses', 'Convulsions, hallucinations, miscarriage, dry gangrene\r\n', '1) Abtec Bio Neem plant pesticide\r\n2) ECOFIT\r\n3) Ahimsa liquid mosquito repellent\r\n4) pmw Sodium Boranet powder'),
(6, 'Powdery Mildew', 'Fungal', 28, 34, 60, 80, 88, 104, '1) Grains,\r\n2) Legumes', 'Unopened flower buds may be white, promoting poor growth, decreasing yields, economic loss by weakening\r\n', '1) Serenade garden \r\n2) Sulfur plant fungicide \r\n3) SNS 244 \r\n4) PM wash\r\n'),
(7, 'Root rots', 'Bacterial', 29, 32, 64, 78, 79, 87, 'All Types of plants', 'Attack the roots, poor growth, wilted leaves, early leaf drop, branch dieback\r\n', '1) Chemical fungicids \r\n2) biological agents\r\n'),
(8, 'Rusts', 'Fungal', 31, 39, 70, 83, 79, 95, '1) Wheats,\r\n2) Oats,\r\n3) Barley,\r\n4)Rye', 'Pale leaf spot, black spores on leaves, corky blotches, leaf drop, yellow leaf\r\n', '1) Chemical fungicids \r\n2) biological agents \r\n3) Plant doctor\r\n'),
(9, 'Scab', 'Bacterial or Fungal', 35, 44, 76, 89, 59, 78, '1) Wheat,\r\n2) Rye,\r\n3) Barley,\r\n4) Potateos', 'Olive-green spots, leaves become twisted, leaf drop, fruit may drop, velvety spots on lower surface\r\n', '1) Fungicides \r\n2) Tubers \r\n3) Corms\r\n'),
(10, 'Seed Decay', 'Pathogenic', 30, 37, 60, 80, 91, 104, 'All Types of plants', 'Uneven, poor stands, Green growth on seeds', '1) Ecologists \r\n2) Abscisic acid \r\n3) Plant doctor\r\n'),
(11, 'Smuts', 'Fungal', 33, 43, 67, 79, 59, 78, '1) Oats,\r\n2) Barley,\r\n3) Grasses,\r\n4) Corn,\r\n5) Wheat', 'Leaf blade, leaf sheath, twisting leaf, drop leaves\r\n', '1) Vegetable garden \r\n2) organic fishgarden dust \r\n3) Garden inspect spray \r\n'),
(12, 'Soft Rots, Dry Rots', 'Pathogenic', 22, 35, 68, 85, 74, 95, '1) Potateos,\r\n2) Onions,\r\n3) Carrots,\r\n4) Fleshy Organs', 'Water soaked, translucent spots on leaves, stems, foul smell\r\n', '1) ECOFIT-Organic Fungicide\r\n2) Agri Biofungicide\r\n3) Boragold-Fungicide'),
(13, 'Wilts', 'Fungal & Bacterial', 31, 39, 73, 84, 59, 78, '1) Potatoes,\r\n2) Alfalfa,\r\n3) Trees', 'Leaf chlorosis, leaf drop, affected the vascular system, wilting of leaves, stunting of leaf\r\n', '1) Mycostop \r\n2) Yard & garden \r\n3) Mini dragon\r\n'),
(14, 'Blights', 'Bacterial', 28, 32, 60, 80, 79, 95, '1) Fruites Tress,\r\n2) Vegetable,\r\n3) Crops', 'Yellowing leaf, dying of fruits, spotting on leaf, leaf drop\r\n', '1) Rotating crops \r\n2) fungicides \r\n3) antibiotics\r\n'),
(15, 'Crown gall', 'Bacterial', 25, 32, 73, 88, 59, 78, 'Many Crops ,Trees', 'Rough surfaced galls, plants lose vigour, galls on roots\r\n', '1) Protective wrap \r\n2) Sealer & grafting \r\n3) Plant doctor\r\n'),
(16, 'Leaf Spot', 'Fungal', 28, 34, 60, 80, 72, 88, '1) Beans,\r\n2) Peas,\r\n3) Trees,\r\n4) Cotton', 'Verticilium wilt, spots on leaves, leaf drop, poor growth\r\n', '1) Sulfur sprays \r\n2) copper based fungicides \r\n3) garden dust\r\n'),
(17, 'Pith necrosis', 'Pathogenic', 28, 33, 68, 91, 59, 78, 'Greenhouse Tomateos', 'Yellowing leaves, chlorosis, infected on stems, wilting of leaves\r\n', '1) Plant doctor \r\n2) Copper fungicides \r\n3) Bactorial sprays\r\n'),
(18, 'Curly Top', 'Fungal', 25, 32, 60, 80, 88, 104, '1) Beans,\r\n2) sugar Beets,\r\n3) Tomatoes', 'Leaves of infested, crinkled, roots are stunted, plants are dwarfed, rolled inward\r\n', '1) Neem oil \r\n2) Pesticides \r\n3) Sprays\r\n'),
(19, 'Yellowing Of Leafs', 'Viral', 31, 39, 68, 85, 79, 87, '1) Barley,\r\n2) Potatoes,\r\n3) Sugar Beets', 'Yellowing Of Leafs', '1) Pestricides \r\n2) cooper spray \r\n3) Plant doctor\r\n'),
(20, 'Bud Belight', 'Bacterial', 22, 35, 60, 80, 77, 98, 'Soyabeans', 'Yellowing of leaf, sopt on fruit and flower, withering stems, browning fruits\r\n', '1) Serenade garden \r\n2) Liquid cooper \r\n3) Garden dust\r\n'),
(21, 'Root Lesosions', 'Pathogenic', 27, 31, 76, 93, 75, 86, 'More than 2000 Plants Hosts', 'Foliage leaves, poor growth, yellowing leaf, root infection\r\n', '1) Ag lime \r\n2) Oyster shell \r\n3) Digital pH meter\r\n'),
(22, 'Root-knot', 'Bacterial', 25, 32, 60, 70, 87, 102, '1) Tomatoes,\r\n2) Peanuts and other Crop Plants', 'Stunted growth, yellowing leaves, thining plants, damage in patches, premature wiling\r\n', '1) Fungicides \r\n2) Crop rotation \r\n3) Pest contol\r\n'),
(23, 'Hairy Roots', 'Bacterial', 28, 32, 75, 94, 59, 78, '1) Suagr Beets,\r\n2) Soyabeans,\r\n3) Potatoes', 'Overabundant, wrinkled leaves, poor growth, length of root less\r\n', '1) Plant doctor \r\n2) Copper fungicides \r\n3) Bactorial sprays\r\n'),
(24, 'Aster Yellows', 'Bacterial', 25, 33, 80, 90, 73, 89, 'Many Plant Species', 'Yellowing leaves, abnormally bushy growth, deformed flowers, yellows veins\r\n', '1) Serenade garden \r\n2) Liquid cooper \r\n3) Garden dust\r\n'),
(25, 'Pear Decline', 'Pathogenic', 27, 33, 60, 70, 74, 95, 'Pears', 'Poor growth, dieback of shoots, premature reddening, upper rolling of leaves, reduced leaf, reduced fruit, leaf drop\r\n', '1) Rotating crops \r\n2) fungicides \r\n3) antibiotics\r\n'),
(26, 'Western X', 'Viral', 30, 37, 76, 87, 68, 79, 'Stone Fruit Trees', 'leaf coloration, reduecd growth, infected on leaves, leaves become yellowish in late-june\r\n', '1) Mycostop \r\n2) Yard & garden \r\n3) Mini dragon\r\n'),
(27, 'Mosaic Leaf', 'Viral', 25, 32, 81, 89, 59, 78, '1) Tobacco,\r\n2) Corn,\r\n3) Small Grains,\r\n4) Maize,\r\n5) Sugracane', 'Leaves stunted, veins may be lighter, leaves curled, irregular leaf mottling\r\n', '1) Serenade garden\r\n2) Sulfur plant fungicide \r\n3)Plant doctor\r\n'),
(28, 'Bactorial Wilts', 'Bacterial', 27, 33, 77, 98, 75, 86, '1) Corn\r\n2) Tomateos\r\n3) Tobacco\r\n5) Potato', 'Leaf wilting, moisture stress, poor growth, wilting of leaves, drop leaf\r\n', '1) Pesticides \r\n2) Bactericides \r\n3) Non-pesticides chemicals\r\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diseases`
--
ALTER TABLE `diseases`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diseases`
--
ALTER TABLE `diseases`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
