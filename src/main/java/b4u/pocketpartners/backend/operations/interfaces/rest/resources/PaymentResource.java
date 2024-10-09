package b4u.pocketpartners.backend.operations.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResource(Long id,
                              String description,
                              BigDecimal amount,
                              String status,
                              Long userId,
                              Long expenseId,
                              LocalDate dueDate) {
}
