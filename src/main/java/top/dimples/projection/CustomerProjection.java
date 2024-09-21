package top.dimples.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Dimples_YJ
 * @create 2024/9/21
 */
public interface CustomerProjection {
    String getFirstName();

    String getLastName();

    @Value(value = "#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
