package org.carlos.flycommerce.Controllers.App;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.DTO.Branch.BranchCreationDTO;
import org.carlos.flycommerce.Models.MySql.Branch;
import org.carlos.flycommerce.Services.App.BranchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/{id}")
    public Branch getBranch(@PathVariable Integer id) {
        return branchService.getBranch(id);
    }

    @GetMapping("/hotel/{hotel_id}")
    public Branch getBranchByHotel(Integer hotel_id) {
        return branchService.getBranchByHotel(hotel_id);
    }

    @PostMapping
    public Branch createBranch(BranchCreationDTO branch) {
        return branchService.createBranch(branch);
    }
}
