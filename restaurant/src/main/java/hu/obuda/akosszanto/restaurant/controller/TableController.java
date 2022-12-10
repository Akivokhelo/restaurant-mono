package hu.obuda.akosszanto.restaurant.controller;

import hu.obuda.akosszanto.restaurant.model.Table;
import hu.obuda.akosszanto.restaurant.service.TableService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/table")
@Slf4j
public class TableController {


    private TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    @RolesAllowed("USER")
    @Operation(summary = "Get all tables",
            description = "Get all tables",
            tags = {"table"},
            operationId = "getAllTables")
    private List<Table> getTables() {
        return tableService.getTables();
    }

    @GetMapping("/summer")
    @Operation(summary = "Get all summer tables",
            description = "Get all summer tables",
            tags = {"table"},
            operationId = "getAllSummerTables")
    private List<Table> getSummerTables() {
        return tableService.getTablesByWinterReady(true);
    }

    @GetMapping("/winter")
    @Operation(summary = "Get all winter tables",
            description = "Get all winter tables",
            tags = {"table"},
            operationId = "getAllWinterTables")
    private List<Table> getWinterTables() {
        return tableService.getTablesByWinterReady(false);
    }

    @GetMapping("/available")
    @Operation(summary = "Get all available tables",
            description = "Get all available tables",
            tags = {"table"},
            operationId = "getAllAvailableTables")
    private List<Table> getAvailableTables(@RequestParam("from") Timestamp from, @RequestParam("to") Timestamp to) {
        return tableService.getTablesAvailableAtTime(from, to);
    }
}
