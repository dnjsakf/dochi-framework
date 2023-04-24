package com.dochi.labs.web.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dochi.labs.common.dao.CommonSqlDAO;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    CommonSqlDAO commonSql;

    @GetMapping("")
    public ModelAndView gerBoard(ModelAndView mv) {
        
        try {
            List<Map<String, Object>> list = commonSql.selectList("Board.selectRatingList", null);
            mv.addObject("datas", list);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        mv.setViewName("board/index");
        
        return mv;
    }
}
