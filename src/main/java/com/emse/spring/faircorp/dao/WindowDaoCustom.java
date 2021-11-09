package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface WindowDaoCustom {

        void deleteByRoom(Long id);
        void deleteAllWindowsInARoom(Long id);
        List<Window> findRoomOpenWindows(Long id);
        List<Window> findWindowsInARoom(Long id);

}
