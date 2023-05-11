INSERT INTO category (id, alias, description, name) VALUES (1, 'videoCardCategory', 'Категория с видеокартами', 'Видеокарты');
INSERT INTO category (id, alias, description, name) VALUES (2, 'processingCategory', 'Категория с процессорами', 'Процессоры');

INSERT INTO video_card
    (id, date_create, description, name, original_url, price, bus_width, fan_number, category_id, chip_manufacturer_id, connection_interface_id, gpu_id, video_memory_type_id, video_ram_id, video_vendor_id)
VALUES (1, 10, 'rtx', 'RTX 3070 TI', null, 100000, 512, 3, 1, null, null, null, null, null, null);
INSERT INTO video_card
    (id, date_create, description, name, original_url, price, bus_width, fan_number, category_id, chip_manufacturer_id, connection_interface_id, gpu_id, video_memory_type_id, video_ram_id, video_vendor_id)
VALUES (1, 10, 'gtx', 'GTX 1660 SUPER', null, 50000, 256, 1, 1, null, null, null, null, null, null)