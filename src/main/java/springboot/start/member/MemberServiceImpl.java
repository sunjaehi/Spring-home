package springboot.start.member;
//MemberServiecImpl은 MemoryMemberRepository를 의존하지 않음
//MemberServiceImpl입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지) 알 수 없음
//어떤 구현 객체를 주입할지는 오직 외부 'AppConfig' 에서만 결정됨
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
