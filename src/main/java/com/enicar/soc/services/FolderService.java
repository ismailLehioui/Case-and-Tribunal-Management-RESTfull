package com.enicar.soc.services;

import com.enicar.soc.entities.Folder;
import com.enicar.soc.exceptions.NotFoundException;
import com.enicar.soc.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService implements IFolderService{
    FolderRepository folderRepository;

    @Override
    public List<Folder> getAllFolder() {
        return folderRepository.findAll();
    }

    @Override
    public Folder deleteFolder(Long id) {
        Folder f = folderRepository.getReferenceById(id);
        if(f == null){
            throw new NotFoundException("this folder not found !");
        }
        folderRepository.deleteById(id);
        return f;
    }

    @Override
    public Folder getFolderById(Long id) {
        Folder f = folderRepository.getReferenceById(id);
        if(f == null){
            throw new NotFoundException("this folder not found !");
        }
        return f;
    }

    @Override
    public Folder getFolderByName(String name) {
        Folder f = folderRepository.getFolderByName(name);
        if(f == null){
            throw new NotFoundException("this folder not found");
        }
        return f;
    }

    @Override
    public Folder addFolder(Folder f) {
        return folderRepository.save(f);
    }
}
