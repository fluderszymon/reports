USE reports;

INSERT INTO
`reports`.`employee` 
(`id`, `email`, `first_name`, `last_name`) 
VALUES 
('1', 'af@wp.pl', 'Anna', 'Fąk'),
('2', 'kb@wp.pl', 'Kasia', 'Bąk'),
('3', 'zn@wp.pl', 'Zosia', 'Nowak'),
('4', 'kk@wp.pl', 'Kasia', 'Kowalska'),
('5', 'mw@wp.pl', 'Małgosia', 'Wójcik'),
('6', 'az@wp.pl', 'Adam', 'Zieliński'),
('7', 'bw@wp.pl', 'Bartek', 'Wiśniewski'),
('8', 'jl@wp.pl', 'Jan', 'Lewandowski'),
('9', 'ok@wp.pl', 'Olaf', 'Kozak'),
('10', 'kw@wp.pl', 'Krzysiek', 'Wróbel');


INSERT INTO 
`reports`.`product_format` 
(`id`, `format_name`, `format_number`, `max_height`, `max_length`, `max_weight`, `max_width`, 
`min_compressive_strength_in_mpa`, `min_height`, `min_length`, `min_weight`, `min_width`) 
VALUES 
('1', '11,5', '1', '240', '502', '10', '120', '10', '235', '498', '9', '110'),
('2', '25', '2', '240', '502', '13', '255', '5', '235', '498', '12', '245'),
('3', '44', '3', '240', '502', '15', '450', '14', '235', '498', '14', '430'),
('4', '500', '4', '240', '502', '18', '505', '18', '235', '498', '17', '322'),
('5', '8', '5', '240', '502', '8', '90', '8', '235', '498', '7', '70'),
('6', '15', '6', '240', '502', '11', '160', '10', '235', '498', '10', '140');

INSERT INTO 
`reports`.`compressive_strength_test` 
(`id`, `batch`, `test_date`, `measured_strength`, `employee_id`, `product_format_id`) 
VALUES 
('1', '24-01', '2024-02-22 15:25:30.000000', 11, '2', '1'),
('2', '24-02', '2024-04-14 14:20:00.000000', 9, '3', '1'),
('3', '24-03', '2024-05-13 10:50:20.000000', 12, '4', '6'),
('4', '24-04', '2024-09-27 11:14:30.000000', 16, '8', '5'),
('5', '24-05', '2024-10-08 13:22:20.000000', 10, '9', '4'),
('6', '24-06', '2024-11-14 12:06:40.000000', 11, '2', '2'),
('7', '25-01', '2024-02-22 14:30:13.000000', 18, '5', '3'),
('8', '25-02', '2024-03-14 14:50:12.000000', 12, '1', '3');


