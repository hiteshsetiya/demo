 CREATE TABLE `product` (
  `product_id` bigint NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `fk_asset_id` bigint DEFAULT NULL,
  `fk_categories_Id` bigint DEFAULT NULL,
  `color` varchar(250) DEFAULT NULL,
  `price` varchar(250) DEFAULT NULL,
    PRIMARY KEY (`product_id`),
    UNIQUE KEY `UKiqykp810ijkhct1tix3j7hgk3` (`color`,`name`));

 CREATE TABLE `categories` (
   `categories_id` bigint NOT NULL,
   `Categoriesname` varchar(250) DEFAULT NULL,
     PRIMARY KEY (`categories_id`) );