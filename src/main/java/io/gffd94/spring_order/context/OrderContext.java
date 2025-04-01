package io.gffd94.spring_order.context;

import io.gffd94.spring_order.Service.OrderSerivce;
import io.gffd94.spring_order.Service.VoucherService;
import io.gffd94.spring_order.order.Order;
import io.gffd94.spring_order.repository.OrderRepository;
import io.gffd94.spring_order.repository.VoucherRepository;
import io.gffd94.spring_order.voucher.Voucher;

import java.util.Optional;
import java.util.UUID;

public class OrderContext {
    public VoucherRepository voucherRepository() {
        return new VoucherRepository() {
            @Override
            public Optional<Voucher> findById(UUID voucherId) {
                return Optional.empty();
            }
        };
    }

    public OrderRepository orderRepository() {
        return new OrderRepository() {
            @Override
            public void insert(Order order) {

            }
        };
    }

    public VoucherService voucherService() {
        return new VoucherService(voucherRepository());
    }

    public OrderSerivce orderSerivce() {
        return new OrderSerivce(orderRepository(), voucherService());
    }

}
