package io.gffd94.spring_order.repository;

import io.gffd94.spring_order.voucher.Voucher;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
    Optional<Voucher> findById(UUID voucherId);
}
