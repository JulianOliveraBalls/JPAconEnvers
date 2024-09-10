package org.example;

import entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Juli");

        try {
            entityManager.getTransaction().begin();
            /*
            Articulo articulo = Articulo.builder()
                    .cantidad(10)
                    .denominacion("Dentrifico")
                    .precio(1250)
                    .build();
            List<Categoria> categorias = new ArrayList<>();
            Categoria categoria = Categoria.builder()
                    .denominacion("Higiene Personal")
                    .build();
            categorias.add(categoria);
            articulo.setCategorias(categorias);
            Cliente cliente = Cliente.builder()
                    .apellido("Olivera Balls")
                    .nombre("Julian")
                    .dni(45024273)
                    .build();
            Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("Juan B Justo")
                    .numero(1761)
                    .build();
            cliente.setDomicilio(domicilio);
            Factura factura = Factura.builder()
                    .fecha("20/10/2024")
                    .numero(4)
                    .total(3000)
                    .build();
            List<DetalleFactura> detalles = new ArrayList<>();
            DetalleFactura detalleFactura = DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(3000)
                    .articulo(articulo)
                    .factura(factura)
                    .build();
            detalles.add(detalleFactura);
            factura.setDetalles(detalles);
            factura.setCliente(cliente);

*/

            Factura factura = entityManager.find(Factura.class,3L);
            //factura.setNumero(12);



            entityManager.remove(factura);

            entityManager.getTransaction().commit();




        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar");}


        entityManager.close();
        entityManagerFactory.close();
    }
}