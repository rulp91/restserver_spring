package es.uma.isia.restserver.controller;

import es.uma.isia.restserver.utils.NifCifNieValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestApi {

    @Operation(summary = "Retorna la letra correspondiente a un dni dado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Letra del dni",
                    content = {@Content(mediaType = "text/plain")}),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("isia/dni")
    public ResponseEntity<String> getLetraNif(@RequestParam int nif ) {
        String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        String output = String.valueOf(NIF_STRING_ASOCIATION.charAt(nif % 23));


        return new ResponseEntity<String>(output, HttpStatus.OK);
    }

    @Operation(summary = "Retorna la nif/nie es válido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Retorna true/flase"),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("isia/validar_nifnie")
    public ResponseEntity<Boolean> isValidNif(@RequestParam String nif ) {

        return new ResponseEntity<Boolean>(NifCifNieValidator.isNifNie(nif), HttpStatus.OK);
    }

    @Operation(summary = "Retorna la Cif es válido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Retorna true/flase"),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("isia/validar_cif")
    public ResponseEntity<Boolean> isValidCif(@RequestParam String cif ) {

        return new ResponseEntity<Boolean>(NifCifNieValidator.isCIF(cif), HttpStatus.OK);
    }
}
