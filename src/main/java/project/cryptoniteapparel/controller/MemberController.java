package project.cryptoniteapparel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cryptoniteapparel.model.Member;
import project.cryptoniteapparel.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class MemberController {

    private final MemberService memberService;

//    Get Mapping Controller

    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.getAllMembers());
    }

    @GetMapping("/getMemberById/{id}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.getMemberById(id));
    }

//    Post Mapping Controller

    @PostMapping("/createMember")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.createMember(member));
    }

//    Delete Mapping Controller

    @DeleteMapping("/deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.deleteMember(id));
    }

//    Put Mapping Controller

    @PutMapping("/editMember/{id}")
    public ResponseEntity<Member> editMember(@RequestBody Member member, @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.editMember(member, id));
    }

//    Patch Mapping Controller

    @PatchMapping("/buyProduct/{memberId}/{productId}")
    public ResponseEntity<Member> buyProduct(@PathVariable Long memberId, @PathVariable Long productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.buyProduct(memberId, productId));
    }

    @PatchMapping("/subscribeToInsights/{id}")
    public ResponseEntity<Member> subscribeToInsights(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.subscribeToInsights(id));
    }

    @PatchMapping("/unsubscribeFromInsights/{id}")
    public ResponseEntity<Member> unsubscribeFromInsights(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.unsubscribeFromInsights(id));
    }
}
