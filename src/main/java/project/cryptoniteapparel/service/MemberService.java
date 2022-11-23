package project.cryptoniteapparel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.cryptoniteapparel.model.Member;
import project.cryptoniteapparel.model.Product;
import project.cryptoniteapparel.repository.MemberRepo;
import project.cryptoniteapparel.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final ProductRepo productRepo;

//    Get Mapping Service

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepo.findById(id);
    }

//    Post Mapping

    public Member createMember(Member member) {
        Member addedMember = memberRepo.save(member);
        int memberRepoSize = memberRepo.findAll().size();

        return memberRepo.findAll().get(memberRepoSize - 1);
    }

//    Delete Mapping

    public String deleteMember(Long id) {
        Optional<Member> member = memberRepo.findById(id);

        if (member.isEmpty()) {
            return "Could not find member with id: " + id;
        }

        memberRepo.deleteById(id);
        return "Member with id " + id + " has been deleted.";
    }

//    Put Mapping

    public Member editMember(Member member, Long id) {
        Member currentMemberDetails = memberRepo.findById(id).get();

        member.setId(id);
        if (member.getEmail() == null || member.getEmail().length() == 0) {
            member.setEmail(currentMemberDetails.getEmail());
        }
        if (member.getFirstName() == null || member.getFirstName().length() == 0) {
            member.setFirstName(currentMemberDetails.getFirstName());
        }
        if (member.getLastName() == null || member.getLastName().length() == 0) {
            member.setLastName(currentMemberDetails.getLastName());
        }
        if (member.getPassword() == null || member.getPassword().length() == 0) {
            member.setPassword(currentMemberDetails.getPassword());
        }
        if (member.getProductsOwned() == null) {
            member.setProductsOwned(currentMemberDetails.getProductsOwned());
        }
        if (member.getSubscribedToInsights() == null) {
            member.setSubscribedToInsights(currentMemberDetails.getSubscribedToInsights());
        }

        return memberRepo.save(member);
    }

//    Patch Mapping

    public Member buyProduct(Long memberId, Long productId) {
        Member member = memberRepo.findById(memberId).get();
        Product product = productRepo.findById(productId).get();

        List<Product> ownedProducts = member.getProductsOwned();
        ownedProducts.add(product);
        member.setProductsOwned(ownedProducts);
        memberRepo.save(member);

        return member;
    }

    public Member subscribeToInsights(Long memberId) {
        Member member = memberRepo.findById(memberId).get();
        member.setSubscribedToInsights(true);
        memberRepo.save(member);

        return member;
    }

    public Member unsubscribeFromInsights(Long memberId) {
        Member member = memberRepo.findById(memberId).get();
        member.setSubscribedToInsights(false);
        memberRepo.save(member);

        return member;
    }
}
