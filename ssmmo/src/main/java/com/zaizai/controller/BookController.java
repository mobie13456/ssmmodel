package com.zaizai.controller;


import com.zaizai.domain.Book;
import com.zaizai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        Boolean flag=bookService.save(book);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result update(@RequestBody Book book) {
        Boolean flag= bookService.update(book);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Boolean flag= bookService.delete(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }




    @GetMapping
    public Result selectAll() {
        List<Book> books=bookService.selectAll();
        Integer code=books!=null?Code.GET_OK:Code.GET_ERR;
        String msg=books!=null?"":"查询数据失败，请稍后重试！";
        return new Result(code,books,msg);
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {

/*

            if(id==2){
                throw new BusinessException(Code.BUSINESS_ERR,"请不要用你的技术挑战我的耐性");
            }

*/



       /* try{
            int i=1/0;
        }catch (Exception e ){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"系统访问超时，请重试",e);

        }*/





        Book book=bookService.selectById(id);
        Integer code=book!=null?Code.GET_OK:Code.GET_ERR;
        String msg=book!=null?"":"查询数据失败，请稍后重试！";
        return new Result(code,book,msg);
    }

}
