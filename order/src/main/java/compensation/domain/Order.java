package compensation.domain;

import compensation.domain.OrderPlaced;
import compensation.domain.OrderCancelled;
import compensation.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="Order_table")
@Data
@Getter
@Setter
//<<< DDD / Aggregate Root
public class Order  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long id;    
    
    
private String productId;    
    
    
private Integer qty;    
    
    
private String customerId;    
    
    
private Double amount;    
    
    
private String status;    
    
    
private String address;

    @PostPersist // Order가 스스로 영속화(instance)된 후 실행되는 함수
    public void onPostPersist(){

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        // OrderCancelled orderCancelled = new OrderCancelled(this);
        // orderCancelled.publishAfterCommit();

    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




//<<< Clean Arch / Port Method
    public static void updateStatus(OutOfStock outOfStock){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        repository().findById(
                outOfStock.getOrderId()
            ).ifPresent(order->{
            
            order.setStatus("OrderCancelled");
            repository().save(order);


         });

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
