package com.example.pruebahexgonal.demo.sales.application;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.pruebahexgonal.demo.clients.domain.ClientRepositoryPort;
import com.example.pruebahexgonal.demo.clients.domain.Clients;
import com.example.pruebahexgonal.demo.exception.CustomException;
import com.example.pruebahexgonal.demo.sales.domain.Sales;
import com.example.pruebahexgonal.demo.sales.domain.SalesRepositoryPort;

import jakarta.transaction.Transactional;

@Service
public class SalesServices {
    private final SalesRepositoryPort salesPort;
    private final ClientRepositoryPort clientPort;

    public SalesServices(SalesRepositoryPort salesPort, ClientRepositoryPort clientPort) {
        this.salesPort = salesPort;
        this.clientPort= clientPort;
    }
    
    @Transactional
    public Sales createSales(Sales sale){
        Clients client = clientPort.findById(sale.getCliente().getId()).orElse(new Clients());
        if(client==null){
            throw new CustomException("Cliente con id "+ sale.getCliente().getId()+" no existe");
        }
               
        if (sale.getFechaCompra()==null){
            sale.setFechaCompra(LocalDate.now());
        }
        sale.setCliente(client);
        return salesPort.save(sale);
    }

    @Transactional
    public List<Sales> findAll(){
        return salesPort.findAll();
    }
    
    @Transactional
    public Sales findSalesById(Long id){
        return salesPort.findById(id);
    }

    @Transactional
    public void deleteById(Long id){
        if(!salesPort.existsById(id)) throw new CustomException(id,"sales");
        salesPort.deleteById(id);
    }

    @Transactional
    public Sales update(Long id, Sales incoming){
        Sales current = findSalesById(id);
        if(current == null) throw new CustomException(id, "Sales");           
        if (incoming.getDescription() != null) current.setDescription(incoming.getDescription());
        if (incoming.getValorCompra () != null) current.setValorCompra(incoming.getValorCompra());
        if (incoming.getValorVenta() != null) current.setValorVenta(incoming.getValorVenta());
        if (incoming.getCliente() != null) current.setCliente(incoming.getCliente());        
        
        return salesPort.save(current);
    }
}