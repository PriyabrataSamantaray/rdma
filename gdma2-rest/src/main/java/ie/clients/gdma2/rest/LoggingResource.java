package ie.clients.gdma2.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.clients.gdma2.domain.AuditRecord;
import ie.clients.gdma2.domain.ui.PaginatedTableResponse;

@RestController
@RequestMapping("rest/logs")
public class LoggingResource extends BaseDataTableResource{

	private static Logger logger = LoggerFactory.getLogger(LoggingResource.class);


	@RequestMapping(value="audit")
	public PaginatedTableResponse<AuditRecord> getAuditLogs(@RequestParam  Map<String, String> reqParams){
		logger.debug("getConnectionTypeTable");
		
		String orderByColumn = "id";
		switch (getOrderByColumn(reqParams)){
		case 0:
			orderByColumn = "id";
			break;
		case 1:
			orderByColumn = "auditHeader.id";
			break;
		case 2:
			orderByColumn = "auditHeader.tableID";
			break;
		case 3:
			orderByColumn = "auditHeader.type";
			break;
		case 4:
			orderByColumn = "auditHeader.modifiedBy";
			break;
		case 5:
			orderByColumn = "auditHeader.modifiedOn";
			break;
		case 6:
			orderByColumn = "columnID";
			break;
		case 7:
			orderByColumn = "oldValue";
			break;
		case 8:
			orderByColumn = "newValue";
			break;
		default:
			orderByColumn = "id";
			break;
		}

		logger.debug("orderByColumn: " + orderByColumn);

		PaginatedTableResponse<AuditRecord> resp = serviceFacade.getLoggingService().getPaginatedAuditLogs(
				getSearchValue(reqParams),
				orderByColumn,
				getOrderByDirection(reqParams),
				getStartIndex(reqParams),
				getLength(reqParams)
				);

		resp.setDraw(getDraw(reqParams));
		return resp;
	}
}
