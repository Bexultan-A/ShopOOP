PGDMP         3                {            shop    15.1    15.1 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16423    shop    DATABASE     |   CREATE DATABASE shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Kazakhstan.1251';
    DROP DATABASE shop;
                postgres    false            �            1259    16425    clothes    TABLE     +  CREATE TABLE public.clothes (
    id integer NOT NULL,
    shopname text NOT NULL,
    seasonname text NOT NULL,
    stylename text NOT NULL,
    gendername text NOT NULL,
    agename text NOT NULL,
    typename text NOT NULL,
    name text,
    price numeric,
    color text,
    amount integer
);
    DROP TABLE public.clothes;
       public         heap    postgres    false            �            1259    16424    clothesShop_id_seq    SEQUENCE     �   ALTER TABLE public.clothes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."clothesShop_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �          0    16425    clothes 
   TABLE DATA           �   COPY public.clothes (id, shopname, seasonname, stylename, gendername, agename, typename, name, price, color, amount) FROM stdin;
    public          postgres    false    215   �	       �           0    0    clothesShop_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."clothesShop_id_seq"', 5, true);
          public          postgres    false    214            e           2606    16433    clothes clothesShop_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.clothes
    ADD CONSTRAINT "clothesShop_pkey" PRIMARY KEY (id, shopname, seasonname, stylename, gendername, agename, typename);
 D   ALTER TABLE ONLY public.clothes DROP CONSTRAINT "clothesShop_pkey";
       public            postgres    false    215    215    215    215    215    215    215            �   �   x���A�0��/?F�nóxx���K���Ul���2p�H�ǫй���a
�{y��hG��	��4'vYe�4(��	sL���9�=�wQ�ۺ|�6d��A5x��sD�(���S�1\�_�Q��DXѬ*C�� !;O�     