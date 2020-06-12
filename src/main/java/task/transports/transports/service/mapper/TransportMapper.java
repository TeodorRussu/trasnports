package task.transports.transports.service.mapper;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.Map;

@Component
public interface TransportMapper {

    List<Transport> mapTransportDTOsToTransport(List<TransportDTO> transportDTOs);

    TransportSummary mapTransportToTransportSummary(Map<String, Integer> transportsTotals);
}
