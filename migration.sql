CREATE DATABASE IF NOT EXISTS comrade_snifter_db;

use comrade_snifter_db;
drop table IF EXISTS category;
drop table IF EXISTS drink_Category;
drop table IF EXISTS drinks;
drop table IF EXISTS users;
Create table if not exists users(
                                    id int unsigned not null auto_increment primary key,
                                    username varchar(255) not null,
                                    email varchar(255) not null,
                                    password varchar(255) not null,
                                    drink_favorite varchar(255) # a list of drink id's as favorites can be queried and pulled out as an int list
);
CREATE table if not exists drinks(
                                     id int unsigned not null auto_increment primary key,
                                     user_id int unsigned not null,
                                     name varchar(255) not null,
                                     instructions varchar(255) not null,
                                     ingredients varchar(255) not null,
                                     image varchar(255),
                                     FOREIGN KEY (user_id) references users(id)
);
create table if not exists drink_Category(
                                             id int unsigned auto_increment primary key,
                                             name varchar(255) #      BRANDY, WHISKEY, BOURBON
);
create table if not exists category(
                                       alcohol_id int unsigned not null,
                                       liquor_type int unsigned not null,
                                       FOREIGN KEY (alcohol_id) references drinks(id),
                                       FOREIGN KEY (liquor_type) references drink_Category(id)
);
insert into users(username, email, password) VALUES ('admin', 'admin@admin.com', '$2a$12$o5y9Peq1GDMgGQiR5gyS6OtROQO4SKe0uWrSg8rq0wSNXoLEEpn5e');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Bermuda Highball', 'Pour brandy, gin, and dry vermouth into a highball glass over ice cubes. Fill with carbonated water and stir. Add the twist of lemon and serve. (Ginger ale may be substituted for carbonated water, if preferred.', 'Brandy 3/4 oz, Gin 3/4 oz, Dry Vermouth 3/4 oz, Carbonated water, Lemon peel', 'https://www.thecocktaildb.com/images/media/drink/qrvtww1441206528.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Brandon and Will''s Coke Float', 'Scoop two large scoops of vanilla ice-cream into frosted beer mug. Next, add 2 ounces Maker''s Mark. Then, pour in coke. Gently stir and enjoy.', 'Vanilla ice-cream 2 scoops, Coca-Cola 1 can, Bourbon 2 oz', 'https://www.thecocktaildb.com/images/media/drink/xspxyr1472719185.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'John Collins', 'Pour all ingredients directly into highball glass filled with ice. Stir gently. Garnish. Add a dash of Angostura bitters.', 'Bourbon 2 oz, Lemon juice 1 oz, Sugar 1 tsp superfine, Club soda 3 oz, Maraschino cherry 1, Orange 1', 'https://www.thecocktaildb.com/images/media/drink/0t4bv71606854479.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Old Fashioned', 'Place sugar cube in old fashioned glass and saturate with bitters, add a dash of plain water. Muddle until dissolved. Fill the glass with ice cubes and add whiskey. Garnish with orange twist, and a cocktail cherry', 'Bourbon 4.5 cL, Angostura bitters 2 dashes, Sugar 1 cube, Water dash', 'https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Amaretto Shake', 'Combine all ingredients in a blender and blend at high speed until smooth. Serve in chilled glass garnished with bittersweet chocolate shavings.', 'Chocolate ice-cream 2 scoops, Brandy 2 oz, Amaretto 2 oz', 'https://www.thecocktaildb.com/images/media/drink/xk79al1493069655.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Gentleman''s Club', 'In an old-fashioned glass almost filled with ice cubes, combine all of the ingredients. Stir well.', 'Gin 1 1/2 oz, Brandy 1 oz, Sweet Vermouth 1 oz, Club soda 1 oz', 'https://www.thecocktaildb.com/images/media/drink/k2r7wv1582481454.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Port Wine Cocktail', 'Stir ingredients with ice, strain into a cocktail glass, and serve.', 'Port 2 1/2 oz, Brandy 1/2 tsp', 'https://www.thecocktaildb.com/images/media/drink/qruprq1441553976.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Porto flip', 'Shake ingredients together in a mixer with ice. Strain into glass, garnish and serve.', 'Brandy 3 parts, Port 9 parts, Egg Yolk 2 parts', 'https://www.thecocktaildb.com/images/media/drink/64x5j41504351518.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Stinger', 'Pour in a mixing glass with ice, stir and strain into a cocktail glass. May also be served on rocks in a rocks glass.', 'Brandy 1 1/2 oz, White Creme de Menthe 1/2 oz', 'https://www.thecocktaildb.com/images/media/drink/2ahv791504352433.jpg');
insert into drinks(user_id, name, instructions, ingredients, image) VALUES (1, 'Kioki Coffee', 'Stir. Add whipped cream to the top.', 'Kahlua 1 oz, Brandy 1/2 oz, Coffee', 'https://www.thecocktaildb.com/images/media/drink/uppqty1441247374.jpg');


select *
from users;