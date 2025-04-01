package io.gffd94.spring_order.Service;

import io.gffd94.spring_order.repository.VoucherRepository;
import io.gffd94.spring_order.voucher.Voucher;

import java.util.UUID;

public class VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException("Voucher not found for id " + voucherId));
    }

    public void useVoucher(Object voucher) {
    }
}
