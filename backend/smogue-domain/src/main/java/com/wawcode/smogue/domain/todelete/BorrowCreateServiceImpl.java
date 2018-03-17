//package com.wawcode.smogue.domain.todelete;
//
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.altkom.asc.library.domain.api.borrow.BorrowCreateDto;
//import pl.altkom.asc.library.domain.api.borrow.BorrowCreateService;
//import pl.altkom.asc.library.domain.api.borrower.BorrowerChosenToBorrowDto;
//import pl.altkom.asc.library.domain.api.item.BookDetailDto;
//import pl.altkom.asc.library.domain.persistence.borrow.Borrow;
//import pl.altkom.asc.library.domain.persistence.borrow.BorrowRepository;
//import pl.altkom.asc.library.domain.persistence.borrower.Borrower;
//import pl.altkom.asc.library.domain.persistence.borrower.BorrowerRepository;
//import pl.altkom.asc.library.domain.persistence.item.Item;
//import pl.altkom.asc.library.domain.persistence.item.ItemRepository;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//public class BorrowCreateServiceImpl implements BorrowCreateService {
//
//    private static final Logger log = LoggerFactory.getLogger(BorrowCreateServiceImpl.class);
//    private static final long TYPICAL_PERIOD_OF_BORROWING = 2L;
//    private static final String DATABASE_LIBRARY_ADMIN = "library";
//    private static final int NUMBER_OF_BORROWED_COPIES = 1;
//
//    private LocalDateTime BORROW_DUE_DATE_TIME = LocalDateTime.now().plusWeeks(TYPICAL_PERIOD_OF_BORROWING);
//
//    private BorrowRepository borrowRepository;
//    private ItemRepository itemRepository;
//    private BorrowerRepository borrowerRepository;
//    private ModelMapper modelMapper;
//
//    @Autowired
//    public BorrowCreateServiceImpl(BorrowRepository borrowRepository, ItemRepository itemRepository, BorrowerRepository borrowerRepository, ModelMapper modelMapper) {
//        this.borrowRepository = borrowRepository;
//        this.itemRepository = itemRepository;
//        this.borrowerRepository = borrowerRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public BorrowCreateDto createBorrow(BookDetailDto bookDetailDto, BorrowerChosenToBorrowDto borrowerChosenToBorrowDto) {
//        Item chosenItem = itemRepository.findOne(bookDetailDto.getId());
//        boolean isAvailable = chosenItem.isAvailable();
//        Borrow borrow;
//        if (isAvailable) {
//            Optional<Borrower> optionalBorrower = borrowerRepository.findByEmail(borrowerChosenToBorrowDto.getEmail());
//            Borrower chosenBorrower = optionalBorrower.orElseThrow(() -> new IllegalArgumentException("Borrower with given EMAIL doesn't exist"));
//            borrow = borrowItem(chosenItem, chosenBorrower);
//        } else {
//            log.error("Item isn't available, number of copies is equal to zero");
//            throw new IllegalStateException("Item isn't available, number of copies is equal to zero");
//        }
//        return convertBorrowEntityToDto(borrow);
//    }
//
//    private Borrow borrowItem(Item chosenItem, Borrower chosenBorrower) {
//        Borrow borrow = createBorrow(chosenItem, chosenBorrower);
//        updateItemNumberOfCopies(chosenItem);
//        addBorrowToBorrower(chosenBorrower, borrow);
//        return borrow;
//    }
//
//    private Borrow createBorrow(Item chosenItem, Borrower chosenBorrower) {
//        Borrow borrow = new Borrow(BORROW_DUE_DATE_TIME, DATABASE_LIBRARY_ADMIN, NUMBER_OF_BORROWED_COPIES, chosenItem, chosenBorrower);
//        borrowRepository.save(borrow);
//        log.info("Item was borrowed by {} ", chosenBorrower.getEmail());
//        return borrow;
//    }
//
//    private void updateItemNumberOfCopies(Item chosenItem) {
//        chosenItem.borrowCopiesOfItem(NUMBER_OF_BORROWED_COPIES);
//        itemRepository.save(chosenItem);
//        log.info("Number of copies chosen Item was updated, actual number copies is equal to {} ", chosenItem.getNumberOfCopies() );
//    }
//
//    private void addBorrowToBorrower(Borrower chosenBorrower, Borrow borrow) {
//        chosenBorrower.addBorrowToBorrower(borrow);
//        borrowerRepository.save(chosenBorrower);
//        log.info("Borrow with chosen Item was save in the Borrower account");
//    }
//
//    private BorrowCreateDto convertBorrowEntityToDto(Borrow borrow) {
//        return modelMapper.map(borrow, BorrowCreateDto.class);
//    }
//
//}
